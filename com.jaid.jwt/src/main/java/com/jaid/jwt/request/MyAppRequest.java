package com.jaid.jwt.request;

import lombok.Data;

@Data
public class MyAppRequest {
 private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
