package com.jaid.rest.Iservice;

import java.util.concurrent.CompletableFuture;

public interface IAysncService {
	public void performAsyncTask();

	public CompletableFuture<String> performAsyncTaskWithRespose();

	CompletableFuture<String> asyncMergeServicesResponse() throws InterruptedException;
}
