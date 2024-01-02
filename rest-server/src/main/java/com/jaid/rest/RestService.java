package com.jaid.rest;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ServiceInstanceRestController {

	private final static Integer limit = 10;

	@RequestMapping("/service-instances/hello")
	public String getHello(String userId, String location) {

		/*
		 * HashMap<String,String> hashMap= new HashMap<String,String>();
		 * HashMap<String,Integer> hashMap2= new HashMap<String,Integer>();
		 * if(hashMap.get(userId).isEmpty() || hashMap.get(userId) == null) {
		 * hashMap.put(userId, location); hashMap2.put(userId,1 ); }else {
		 * 
		 * int x= hashMap2.get(userId); if(x<limit) { if
		 * (location.equals(hashMap.get(userId))) { hashMap.put(userId, location);
		 * 
		 * hashMap2.put(userId,x+1 ); }else { hashMap.put(userId, location);
		 * hashMap2.put(userId,1 ); }
		 * 
		 * }else {
		 * 
		 * execute code to block or deny }
		 * 
		 * }
		 */

		return "Hello this is first service.";
	}
}
