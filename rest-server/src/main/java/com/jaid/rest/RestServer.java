package com.jaid.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient

public class RestServer {

	public static void main(String[] args) {
		SpringApplication.run(RestServer.class, args);
	}

}
