package com.social.exception;

import java.util.Date;


public class ExceptionModel {
	private String msg;
	private String details;
	private Date timeStamp;

	public ExceptionModel() {
	}

	public ExceptionModel(String msg, String details, Date timeStamp) {
		super();
		this.msg = msg;
		this.details = details;
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public String getDetails() {
		return details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

}
