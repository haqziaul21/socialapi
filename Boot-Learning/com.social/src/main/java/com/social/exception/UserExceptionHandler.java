package com.social.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserException ex, WebRequest request)
			throws Exception {
		return new ResponseEntity<>(new ExceptionModel(ex.getMsg(), request.getDescription(false), new Date()),
				ex.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGLobalException(Exception ex, WebRequest request) throws Exception {
		return new ResponseEntity<>(new ExceptionModel(ex.getMessage(), request.getDescription(false), new Date()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new ExceptionModel(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
				request.getDescription(false), new Date()), status);
	}
}
