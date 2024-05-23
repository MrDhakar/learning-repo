package com.jaid.jwt.api.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements IMyUserDetailService,UserDetailsService {

	/*
	 * public UserDetailsService userDetailsService(String username) {
	 * 
	 * UserDetails user =
	 * User.withUsername("user").password("password").roles("USER").build(); return
	 * new InMemoryUserDetailsManager(user);
	 * 
	 * }
	 */
	@Override
	public UserDetails findByUsername(String username) {

		return new User("JAID", "JAID", (Collection<? extends GrantedAuthority>) new ArrayList<GrantedAuthority>());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		final List<GrantedAuthority> grantedAuths = new ArrayList<>();
	    grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User("JAID", "JAID", grantedAuths);
		
	}
}
