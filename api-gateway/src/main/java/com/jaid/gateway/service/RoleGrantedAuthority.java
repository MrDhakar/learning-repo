package com.jaid.gateway.service;

import org.springframework.security.core.GrantedAuthority;

public class RoleGrantedAuthority implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	private String role;
	
	public RoleGrantedAuthority(String role) {
		super();
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return this.role;
	}

	

}
