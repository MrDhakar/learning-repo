package com.jaid.rest.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.jaid.rest.Iservice.ISecondAsyncService;

@Service
public class SecondAsyncService implements ISecondAsyncService{
	
	@SuppressWarnings("deprecation")
	@Async
	@Override
	public CompletableFuture<String> asyncGetData() throws InterruptedException {
	    System.out.println("Execute method asynchronously Second Service" + Thread.currentThread()
	      .getName());
	    Thread.sleep(4000);
	    return new AsyncResult<>(super.getClass().getSimpleName() + " response !!! ").completable();
	}
}
