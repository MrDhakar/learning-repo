package com.jaid.gateway.Exceptions;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jaid.gateway.constants.ErrorCodes;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> handleApplicationException(final ApplicationException exception,
			final HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, exception.getErrorCode(), exception.getMessage(),
				exception.getHttpStatus().value(), exception.getHttpStatus().name(), request.getRequestURI(),
				request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, exception.getHttpStatus());
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(final ResourceNotFoundException exception,
			HttpHeaders headers, HttpStatus status, HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.CLIENT_ERROR, "Client Request error.",
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), request.getRequestURI(),
				request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> handleUserNotFoundException(final UserNotFoundException exception, HttpHeaders headers,
			HttpStatus status, HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.CLIENT_ERROR, "Client Request error.",
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), request.getRequestURI(),
				request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolation(final ConstraintViolationException exception,
			HttpHeaders headers, HttpStatus status, HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.CLIENT_ERROR, "Client Request error.",
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), request.getRequestURI(),
				request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgumentException(final IllegalArgumentException exception,
			HttpHeaders headers, HttpStatus status, HttpServletRequest request) {

		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.CLIENT_ERROR, "Client Request error.",
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), request.getRequestURI(),
				request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.CLIENT_ERROR, "Client Request error.",
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), request.getRequestURI(),
				request.getMethod(), LocalDateTime.now());

		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(final RuntimeException exception, HttpHeaders headers,
			HttpStatus status, HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.INTERNAL_SERVER_ERROR, "Internal server error.",
				HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
				request.getRequestURI(), request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleUnknownException(final Exception exception, HttpHeaders headers, HttpStatus status,
			HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.INTERNAL_SERVER_ERROR, "Internal server error.",
				HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
				request.getRequestURI(), request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> handleUnknownThrowable(final Throwable exception, HttpHeaders headers, HttpStatus status,
			HttpServletRequest request) {
		var guid = UUID.randomUUID().toString();
		log.error(String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), exception);
		var response = new ErrorResponse(guid, ErrorCodes.INTERNAL_SERVER_ERROR, "Internal server error.",
				HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
				request.getRequestURI(), request.getMethod(), LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
