package com.spring.boot.exception;

import java.util.Date;

import org.apache.http.HttpStatus;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ProductServiceExceptionHandler {

	@ExceptionHandler(resultType =  IllegalStateException.class)
	public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex,WebRequest request) {
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getMessage());
		
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(resultType =  Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception ex,WebRequest request) {
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getMessage());
		
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(resultType =  CommandExecutionException.class)
	public ResponseEntity<Object> handleExecutionException(CommandExecutionException ex,WebRequest request) {
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getMessage());
		
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}
	
}
