package com.jaid.gateway.Exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;
}