package com.jaid.jwt.response;

import lombok.Data;
@Data
public class MyAppResponse {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String str) {
		this.name = str;
	}
}
