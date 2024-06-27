package com.jaid.scheduler.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaid.scheduler.controller.IJobSchedularController;
import com.jaid.scheduler.data.JobScheduleRequest;
import com.jaid.scheduler.data.Response;


@RestController
@RequestMapping("/api/")
public class JobSchedularResource {

	@Autowired
	private IJobSchedularController jobSchedulerController;

	@PostMapping(value = "/job/schedule",headers = {"content-type=application/json"},consumes="application/json",produces = "application/json")
	public @ResponseBody ResponseEntity<Response> scheduleJob(@RequestBody JobScheduleRequest jobScheduleRequest) {
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity(Response.success(jobSchedulerController.schedule(jobScheduleRequest)),httpHeaders,HttpStatus.OK);
	}

}
