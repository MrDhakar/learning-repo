package com.example.serviceregistrationanddiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

record Shape (String name) {};

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistrationAndDiscoveryApplication {

	public static void main(String[] args) {
		System.out.println(new Shape("Circle").name().toString());
		SpringApplication.run(ServiceRegistrationAndDiscoveryApplication.class, args);
	}
	
	
	/*
	 * @Bean public JdbcTemplate jdbcTemplate() { DriverManagerDataSource
	 * driverManagerDataSource = new DriverManagerDataSource();
	 * driverManagerDataSource.setDriverClassName("oracle.jdbc.driver");
	 * driverManagerDataSource.setUsername("");
	 * driverManagerDataSource.setPassword("");
	 * 
	 * return new JdbcTemplate(driverManagerDataSource);
	 * 
	 * }
	 */

}


