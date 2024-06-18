package com.example.serviceregistrationanddiscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyResource {
	

	@Autowired
	private IMyAppController myAppController;
	
	@RequestMapping(value = "/rest/api"/*produces = "application/json"*/)
	public MyAppResponse  mytask() {
		MyAppResponse response = myAppController.api();
		return response;

	}
}
