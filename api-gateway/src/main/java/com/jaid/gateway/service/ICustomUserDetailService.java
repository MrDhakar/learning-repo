package com.jaid.gateway.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.jaid.gateway.entitiy.Users;

public interface ICustomUserDetailService {

	public UserDetails loadUserByUsername(String username);

	public Users registerNewUserAccount(Users user) throws Exception;
}
