package com.jaid.rest.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jaid.rest.Iservice.IAysncService;
import com.jaid.rest.Iservice.IFirstAsyncService;
import com.jaid.rest.Iservice.ISecondAsyncService;

@Service
public class AsynceService implements IAysncService{
	
	@Autowired
    private IFirstAsyncService fisrtService;
    @Autowired
    private ISecondAsyncService secondService;
    
	@Async
	@Override
	public void performAsyncTask() {
        // Simulate a time-consuming task
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Async task completed!");
    }
	
	@Async
	@Override
    public CompletableFuture<String> performAsyncTaskWithRespose() {
        // Simulate a time-consuming task
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
            System.out.println("Async task completed!");
            return CompletableFuture.completedFuture("Async task completed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture("Async task failed to complete!");
    }
	@Override
	public CompletableFuture<String> asyncMergeServicesResponse() throws InterruptedException {
        CompletableFuture<String> fisrtServiceResponse = fisrtService.asyncGetData();
        CompletableFuture<String> secondServiceResponse;
        while(true) {
        	if(fisrtServiceResponse.isDone()) {
        		secondServiceResponse = secondService.asyncGetData();
        	break;
        	}  
        }
        // Merge responses from FirstAsyncService and SecondAsyncService
        return fisrtServiceResponse.thenCompose(fisrtServiceValue -> secondServiceResponse.thenApply(secondServiceValue -> fisrtServiceValue + secondServiceValue));
    }
  
}