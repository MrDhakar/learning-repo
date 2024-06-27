package com.jaid.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.jaid.scheduler.repository.JobRepository;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class JobSchedulerApplication {

	@Autowired
	JobRepository jobRepository;

	public static void main(String[] args) {

		SpringApplication.run(JobSchedulerApplication.class, args);
	}
}
