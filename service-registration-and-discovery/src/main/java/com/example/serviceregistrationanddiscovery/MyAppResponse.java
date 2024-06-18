package com.example.serviceregistrationanddiscovery;

import java.util.List;

public class MyAppResponse {
	private String name;
    private List<UserLead> userLeads;
	public List<UserLead> getUserLeads() {
		return userLeads;
	}

	public void setUserLeads(List<UserLead> userLeads) {
		this.userLeads = userLeads;
	}

	public String getName() {
		return name;
	}

	public void setName(String str) {
		this.name = str;
	}
}
