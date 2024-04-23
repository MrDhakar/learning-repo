package com.jaid.jwt.api.response;

import lombok.Data;

@Data
public class ResponseBuilder<T> {

	private String message;
	private Boolean success;
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

	public ResponseBuilder success(boolean success) {
		this.success = success;
		return this;
	}

	@java.lang.Override
	public String toString() {
		return "ResponseBuilder(message = " + message + ", data = " + data + ")";
	}

	public Response build() {
		return new Response(message, data);
	}

}
