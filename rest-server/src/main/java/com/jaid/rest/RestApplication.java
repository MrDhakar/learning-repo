package com.jaid.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableDiscoveryClient
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
