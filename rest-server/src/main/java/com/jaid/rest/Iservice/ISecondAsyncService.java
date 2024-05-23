package com.jaid.rest.Iservice;

import java.util.concurrent.CompletableFuture;

public interface ISecondAsyncService {
	CompletableFuture<String> asyncGetData() throws InterruptedException;
}
