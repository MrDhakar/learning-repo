package com.example.serviceregistrationanddiscovery;


public class MyAppRequest {
 private String name;
 private String userId;
 private String executionInterval;
 int maxRetryCount;
 boolean isReccuring;
 
public String getExecutionInterval() {
	return executionInterval;
}

public void setExecutionInterval(String executionInterval) {
	this.executionInterval = executionInterval;
}

public int getMaxRetryCount() {
	return maxRetryCount;
}

public void setMaxRetryCount(int maxRetryCount) {
	this.maxRetryCount = maxRetryCount;
}

public boolean isReccuring() {
	return isReccuring;
}

public void setReccuring(boolean isReccuring) {
	this.isReccuring = isReccuring;
}

public String getName() {
	return name;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public void setName(String name) {
	this.name = name;
}
}
