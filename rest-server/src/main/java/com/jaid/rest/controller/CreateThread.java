package com.jaid.rest.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;

import com.jaid.rest.Icontroller.ICreateThread;
import com.jaid.rest.Iservice.IAysncService;

@Controller
public class CreateThread implements ICreateThread {

	@Autowired
	private IAysncService asyncService;

	@Override
	public void createThread() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(0);
		taskExecutor.afterPropertiesSet();

		CountDownLatch countDownLatch = new CountDownLatch(8);
		this.startThreads(taskExecutor, countDownLatch, 8);

		while (countDownLatch.getCount() > 0) {
			System.out.println(taskExecutor.getPoolSize());
			// Assert.assertEquals(1, taskExecutor.getPoolSize());
		}

	}

	public void startThreads(ThreadPoolTaskExecutor taskExecutor, CountDownLatch countDownLatch, int numThreads) {
		for (int i = 0; i < numThreads; i++) {
			taskExecutor.execute(() -> {
				try {
					Thread.sleep(100L * ThreadLocalRandom.current().nextLong(1, 10));
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			});
		}
	}

	@Override
	public void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
		System.out.println("Invoking an asynchronous method. " + Thread.currentThread().getName());
		Future<String> future = asyncService.performAsyncTaskWithRespose();

		while (true) {
			if (future.isDone()) {
				System.out.println("Result from asynchronous process - " + future.get());
				break;
			}
			System.out.println("Continue doing something else. ");
			Thread.sleep(1000);
		}
	}

	@Override
	public void asyncMergeServicesResponse() throws InterruptedException, ExecutionException {
		System.out.println("Invoking an asynchronous method. " + Thread.currentThread().getName());
		CompletableFuture<String> completableFuture = asyncService.asyncMergeServicesResponse();

		while (true) {
			if (completableFuture.isDone()) {
				System.out.println("Result from asynchronous process - " + completableFuture.get());
				break;
			}
			System.out.println("Continue doing something else. ");
			Thread.sleep(1000);
		}
	}

}
