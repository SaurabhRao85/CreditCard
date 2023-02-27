package com.axis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionResponse1(IdNotFoundException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(exception.getErrorMsg());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorInfo>(errorInfo , HttpStatus.NOT_FOUND);
	}
	
	
}
