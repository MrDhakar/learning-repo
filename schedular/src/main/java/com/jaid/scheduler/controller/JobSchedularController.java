package com.jaid.scheduler.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jaid.scheduler.data.JobScheduleRequest;
import com.jaid.scheduler.data.Status;
import com.jaid.scheduler.entity.Job;
import com.jaid.scheduler.entity.Task;
import com.jaid.scheduler.repository.JobRepository;
import com.jaid.scheduler.repository.TaskRepository;
import com.jaid.scheduler.service.IJobSchedularService;

@Controller
public class JobSchedularController implements IJobSchedularController {
	
	@Autowired
	IJobSchedularService jobSchedularService;

	@Autowired
	JobRepository jobRepository;

	@Autowired
	TaskRepository taskRepository;

	private String generateJobId() {
		// TODO Auto-generated method stub
		long timestamp = System.currentTimeMillis();

		String randomStr = generateRandomString(6);

		// Combine them to form the unique ID
		String uniqueId = timestamp + "-" + randomStr;
		return uniqueId;
	}

	private String generateRandomString(int length) {
		// TODO Auto-generated method stub
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for(int i=0;i<length;i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}

	@Override
	public Integer schedule(JobScheduleRequest jobScheduleRequest) {
		Job job = new Job();
		job.setCronExpression(jobScheduleRequest.getCronExpression());
		job.setRetryCount(jobScheduleRequest.getRetryCount());
		job.setJobName(jobScheduleRequest.getJobName());
		Job createdJob = jobRepository.save(job);
		Task task = new Task();
		task.setJobId(createdJob.getId());
		task.setStatus(Status.PENDING);
		Long nextExecutionTime = getNextExecutionTime(jobScheduleRequest.getCronExpression());
		task.setNextExecutionTime(nextExecutionTime);
		taskRepository.save(task);
		return createdJob.getId();
	}


	public Long getNextExecutionTime(String cron) {
		Long nextExecutionTime = LocalDateTime.now()
				.plus(Duration.parse(cron))
				.atZone(ZoneOffset.systemDefault())
				.toInstant()
				.getEpochSecond();
		return nextExecutionTime;
	}

}


/*
API - Schedule Job ()
API - Unschedule job ()
API - Get All scheduled JObs
 */