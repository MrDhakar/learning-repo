package com.jaid.gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jaid.gateway.service.ICustomUserDetailService;

@Configuration
@EnableWebSecurity
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private ICustomUserDetailService userDetailsService;
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		final String name = authentication.getName();
		final String password = authentication.getCredentials().toString();
		
		if (isUserAuthenticated(authentication)) {
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final UserDetails principal = new User(name, password, grantedAuths);
			return new UsernamePasswordAuthenticationToken(principal, password, authentication.getAuthorities());
		}
		else throw new UsernameNotFoundException("User not found:"+authentication.getName());

	}


	private boolean isUserAuthenticated(Authentication authentication) {
		
		final String name = authentication.getName();
		final String password = authentication.getCredentials().toString();
		UserDetails userDetails = userDetailsService.loadUserByUsername(name);
		if(name.equals(userDetails.getUsername()) && password.equals(userDetails.getPassword())) return true;
		else return false;
	}

}