package com.jaid.gateway.Exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String guid;
    private final String errorCode;
    private final String message;
    private final Integer statusCode;
    private final String statusName;
    private final String path;
    private final String method;
    private final LocalDateTime timestamp;
}