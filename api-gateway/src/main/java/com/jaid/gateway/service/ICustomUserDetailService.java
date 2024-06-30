package com.jaid.gateway.service;

import com.jaid.gateway.entitiy.User;

public interface ICustomUserDetailService {

	/*
	 * UserDetails findByUsername(String name);
	 * 
	 * UserDetails loadUserByUsername(String username);
	 */
	public User registerNewUserAccount(User user) throws Exception;
}
