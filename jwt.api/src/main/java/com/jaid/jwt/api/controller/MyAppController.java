package com.jaid.jwt.api.controller;

import org.springframework.stereotype.Controller;

import com.jaid.jwt.api.IController.IMyAppController;
import com.jaid.jwt.api.request.MyAppRequest;
import com.jaid.jwt.api.response.MyAppResponse;

@Controller
public class MyAppController implements IMyAppController {

	@Override
	public MyAppResponse mytask(MyAppRequest myAppRequest) {
		// TODO Auto-generated method stub
		MyAppResponse myAppResponse = new MyAppResponse();
		myAppResponse.setName("My name is :" + myAppRequest.getName());

		return myAppResponse;
	}

}
