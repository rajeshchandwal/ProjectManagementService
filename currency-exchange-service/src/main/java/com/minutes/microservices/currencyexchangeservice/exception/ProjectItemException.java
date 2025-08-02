package com.minutes.microservices.currencyexchangeservice.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;



public class ProjectItemException {
	
	private final  Throwable  throwable;
	private final String message;
	private final HttpStatus httpStatus;
	public ProjectItemException(Throwable throwable, String message, HttpStatus httpStatus) {
		super();
		this.throwable = throwable;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public Throwable getThrowable() {
		return throwable;
	}
	public String getMessage() {
		return message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	

}
