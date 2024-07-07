package com.jaid.gateway.Exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationExceptions extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String errorCode;
    private  String message;
    private  HttpStatus httpStatus;
}