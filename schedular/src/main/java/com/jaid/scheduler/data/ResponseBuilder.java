package com.jaid.scheduler.data;

public class ResponseBuilder<T> {

	private String message;
	private String success;
	private T data;

	ResponseBuilder() {
	}

	public ResponseBuilder data(T data) {
		this.data = data;
		return this;
	}

	public ResponseBuilder message(String message) {
		this.message = message;
		return this;
	}

	public ResponseBuilder success(String success) {
		this.success = success;
		return this;
	}

	@Override
	public String toString() {
		return "ResponseBuilder(message = " + message + ", data = " + data + ")" ;
	}

	public Response build() {
		return new Response(message, data, success);
	}

}
