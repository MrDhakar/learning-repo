package com.jupiter.dev;

import java.sql.Timestamp;

public class TaskSchedule {
	
	String usedId;
	String jobId;
	boolean isRucrring;
	String interval;
	int maxRetryCount;
	Timestamp createdTime;
	Timestamp updatedTime;
	public String getUsedId() {
		return usedId;
	}
	public void setUsedId(String usedId) {
		this.usedId = usedId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public boolean isRucrring() {
		return isRucrring;
	}
	public void setRucrring(boolean isRucrring) {
		this.isRucrring = isRucrring;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public int getMaxRetryCount() {
		return maxRetryCount;
	}
	public void setMaxRetryCount(int maxRetryCount) {
		this.maxRetryCount = maxRetryCount;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public Timestamp getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}	
}
