package com.minutes.microservices.currencyexchangeservice.exception;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProjectItemExceptionHandler {
	
//	public ResponseEntity<Object> handleException(){
//		ProjectItemException projectItemException = new ProjectItemException(
//				
//				);
//		
//	}
	
	
	
	@ExceptionHandler(ProjectItemNotFoundException.class)
	public final ResponseEntity<Object> handleAllException(ProjectItemNotFoundException projectItemNotFoundException)  {
		
		ProjectItemException projectItemException = new ProjectItemException(projectItemNotFoundException.getCause()
				,projectItemNotFoundException.getMessage()
				,HttpStatus.NOT_FOUND);
	
		return new ResponseEntity(projectItemException, HttpStatus.NOT_FOUND);
		
	}
	
	

}
