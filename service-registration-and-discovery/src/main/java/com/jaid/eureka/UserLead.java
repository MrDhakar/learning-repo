package com.example.serviceregistrationanddiscovery;

public class UserLead {
    int id;
    String desc;
    String email;
    int userAssignId;
    String repeatFlag;
	public UserLead(int id, String desc, String email, int userAssignId, String repeatFlag) {
		super();
		this.id = id;
		this.desc = desc;
		this.email = email;
		this.userAssignId = userAssignId;
		this.repeatFlag = repeatFlag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserAssignId() {
		return userAssignId;
	}
	public void setUserAssignId(int userAssignId) {
		this.userAssignId = userAssignId;
	}
	public String getRepeatFlag() {
		return repeatFlag;
	}
	public void setRepeatFlag(String repeatFlag) {
		this.repeatFlag = repeatFlag;
	}
}
