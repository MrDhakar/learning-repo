package com.jaid.jwt.api.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaid.jwt.api.IController.IMyAppController;
import com.jaid.jwt.api.request.MyAppRequest;
import com.jaid.jwt.api.response.Response;

@RestController
public class MyAppResource {
	
	@Autowired
	private IMyAppController myAppController;
	
	//@PreAuthorize("user.role")
	@RequestMapping(value = "/rest/myapp/mytask",method = RequestMethod.GET,headers = {"content-type=application/json"},consumes="application/json",produces = "application/json")
	public @ResponseBody ResponseEntity<Response> mytask(@RequestBody MyAppRequest myAppRequest) {
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity(Response.success(myAppController.mytask(myAppRequest)),httpHeaders,HttpStatus.OK);

	}
}
