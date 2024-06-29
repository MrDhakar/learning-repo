package com.jaid.gateway.service;

import static com.jaid.gateway.model.Constants.HEADER_STRING;
import static com.jaid.gateway.model.Constants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jaid.gateway.util.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
	
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil; // should be final

	@Autowired
	private IMyUserDetailService myUserDetailsService;// should be final

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader(HEADER_STRING);
		String username = null;
		String authToken = null;
		if (header != null && header.startsWith(TOKEN_PREFIX)) {
			authToken = header.replace(TOKEN_PREFIX, "");
			try {
				username = jwtTokenUtil.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				logger.error("an error occured during getting username from token", e);
			} catch (ExpiredJwtException e) {
				logger.warn("the token is expired and not valid anymore", e);
			} catch (SignatureException e) {
				logger.error("Authentication Failed. Username or Password not valid.");
			}
		} else {
			/*
			 * if (isEmpty(header) || !header.startsWith("Bearer ")) {
			 * filterChain.doFilter(request, response); return; }
			 */
			logger.info("Bearer does not exists. Request might be first login.");
			/*
			 * BufferedReader reader = request.getReader(); reader.
			 */
			/*
			 * UserData user = new Gson().fromJson(request.getReader(), UserData.class);
			 * username=user.getUsername();
			 */
			UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
			/*request.getUserPrincipal();
			if(username.equals(userDetails.getUsername()) ) {*/
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails == null ? List.of() : userDetails.getAuthorities());

				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authenticated user " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
		
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails == null ? List.of() : userDetails.getAuthorities());

				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authenticated user " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);

			}
		}

		filterChain.doFilter(request, response);

	}

	private boolean isEmpty(String header) {
		return "".equals(header) || header.isEmpty();
	}

}