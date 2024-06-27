package com.jaid.scheduler.controller;

import com.jaid.scheduler.data.JobScheduleRequest;

public interface IJobSchedularController {
	Integer schedule(JobScheduleRequest jobScheduleRequest);
}
