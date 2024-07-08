package com.jaid.gateway.service;

import static com.jaid.gateway.model.Constants.HEADER_STRING;
import static com.jaid.gateway.model.Constants.TOKEN_PREFIX;
import static com.jaid.gateway.model.Constants.BASIC_AUTH;
import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
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
	private ICustomUserDetailService userDetailService;// should be final
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader(HEADER_STRING);
		request.getUserPrincipal();
		String username = null;
		String authToken = null;
		UserDetails userDetails = null ;
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

			authToken = header.replace(BASIC_AUTH, "");
			Base64 base64 = new Base64();
			String decodedString = new String(base64.decode(authToken.getBytes()));
			String[] str = decodedString.split(":");
			username = str[0];
			String password = str[1];
			userDetails = userDetailService.loadUserByUsername(username);

			if(SecurityContextHolder.getContext().getAuthentication() == null && username.equals(userDetails.getUsername()) && password.equals(userDetails.getPassword()) ) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails == null ? List.of() : userDetails.getAuthorities());

				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authenticated user " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
				
		
		}
		
		if (userDetails.getUsername() != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			
			userDetails = userDetailService.loadUserByUsername(username);

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