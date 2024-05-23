package com.jaid.rest.Iservice;

import java.util.concurrent.CompletableFuture;

public interface IFirstAsyncService {
	CompletableFuture<String> asyncGetData() throws InterruptedException;
}
