package com.jaid.rest.resource;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaid.rest.Icontroller.ICreateThread;
import com.jaid.rest.Iservice.IAysncService;

@RestController
class AysyncCallResource {
	
	@Autowired
	private IAysncService asyncService;
	
	@Autowired
	private ICreateThread createThread;
	
	@RequestMapping(value = "/rest/asynctask")
	public String getHello() {
		asyncService.performAsyncTask();
        return "Async task triggered!";

	}
	@RequestMapping(value = "/rest/createThreads")
	public String startThreads() {
		createThread.createThread();
        return "Async task triggered!";

	}
	@RequestMapping(value = "/rest/testAsyncAnnotationForMethodsWithReturnType")
	public String testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
		createThread.testAsyncAnnotationForMethodsWithReturnType();
        return "Async task triggered!";

	}
	
	@RequestMapping(value = "/rest/asyncMergeServicesResponse")
	public String asyncMergeServicesResponse() throws InterruptedException, ExecutionException {
		createThread.asyncMergeServicesResponse();
        return "Async task triggered!";

	}
}
