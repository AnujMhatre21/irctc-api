package com.learn.irctc.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class globalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setLocalDateTime(LocalDateTime.now());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setError("User Not Found");
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setPath(request.getDescription(false));
		return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
