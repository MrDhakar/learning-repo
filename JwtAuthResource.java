package com.jaid.jwt.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaid.jwt.api.IController.IJwtAuthController;
import com.jaid.jwt.api.model.UserData;
import com.jaid.jwt.api.response.Response;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class JwtAuthResource {
	@Autowired
	private IJwtAuthController jwtAuthController;
	
	@RequestMapping(value = "/api/jwt/generate-token",method = RequestMethod.POST,headers = {"content-type=application/json"},consumes="application/json",produces = "application/json")
	public @ResponseBody ResponseEntity<Response> mytask(@RequestBody UserData userDataReqeust) {
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity(Response.success(jwtAuthController.getJwtAuthToken(userDataReqeust)),httpHeaders,HttpStatus.OK);
	}

}
