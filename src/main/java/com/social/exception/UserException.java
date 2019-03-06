package com.social.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private HttpStatus status;

	public HttpStatus getStatus() {
		return status;
	}
	
	public UserException() {
	}
	
	public UserException(String msg,HttpStatus status) {
		super(msg);
		this.msg = msg;
		this.status=status;
	}

	
	public String getMsg() {
		return msg;
	}
	
}
