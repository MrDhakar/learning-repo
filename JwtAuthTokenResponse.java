package com.jaid.jwt.api.response;

import lombok.Data;

@Data
public class JwtAuthTokenResponse {
	private String token;
	private String username;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
