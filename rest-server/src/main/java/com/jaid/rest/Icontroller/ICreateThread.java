package com.jaid.rest.Icontroller;

import java.util.concurrent.ExecutionException;

public interface ICreateThread {
	void createThread();

	void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException;

	void asyncMergeServicesResponse() throws InterruptedException, ExecutionException;

}
