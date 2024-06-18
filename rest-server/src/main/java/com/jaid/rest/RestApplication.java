package com.jaid.rest;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestApplication.class, args);
	}

	/*
	 * @Bean public Executor taskExecutor() { ThreadPoolTaskExecutor executor = new
	 * ThreadPoolTaskExecutor(); executor.setCorePoolSize(1);
	 * 
	 * executor.setMaxPoolSize(1); executor.setQueueCapacity(10);
	 * 
	 * executor.setThreadNamePrefix("RestCreateThread-"); executor.initialize();
	 * return executor; }
	 */

}
