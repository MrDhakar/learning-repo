package com.jaid.scheduler.data;

public class JobScheduleRequest {
	private String cronExpression;
	private Integer retryCount;
	private String jobName;

	public String getCronExpression() {
		return cronExpression;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public String getJobName() {
		return jobName;
	}
}
