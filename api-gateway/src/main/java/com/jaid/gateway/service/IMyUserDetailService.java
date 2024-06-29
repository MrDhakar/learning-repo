package com.jaid.gateway.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IMyUserDetailService {

	UserDetails findByUsername(String name);

	UserDetails loadUserByUsername(String username);

}
