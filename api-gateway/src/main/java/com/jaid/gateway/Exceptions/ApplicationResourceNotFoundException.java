package com.jaid.gateway.Exceptions;

public class ApplicationResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationResourceNotFoundException(String message) {
		super(message);
	}

	public ApplicationResourceNotFoundException() {
		super();
	}

	public ApplicationResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationResourceNotFoundException(Throwable cause) {
		super(cause);
	}
}
