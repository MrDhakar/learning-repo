package com.example.serviceregistrationanddiscovery;

public class User {

	
	int id;
	String name;
	public int getId() {
		return id;
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
