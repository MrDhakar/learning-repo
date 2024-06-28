package com.example.serviceregistrationanddiscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jupiter.dev.Response;

@RestController
public class JobSchedularResource {

	
	@Autowired
	private IJobSchedularController jobSchedularController;

	@RequestMapping(value = "/rest/api/jobs",method = RequestMethod.POST,headers = {"content-type=application/json"},consumes="application/json",produces = "application/json")
	public @ResponseBody ResponseEntity<Response> mytask(@RequestBody MyAppRequest myAppRequest) {
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity(Response.success(jobSchedularController.getJobsIds(myAppRequest)),httpHeaders,HttpStatus.OK);

	}
}
