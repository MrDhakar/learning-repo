package com.jaid.gateway.Exceptions;

public class ApplicationUserNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationUserNotFoundException(String message) {
		super(message);
	}

	public ApplicationUserNotFoundException() {
		super();
	}

	public ApplicationUserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationUserNotFoundException(Throwable cause) {
		super(cause);
	}
}
