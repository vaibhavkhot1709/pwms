package com.pwms.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value={StudentExistsException.class})
	public ResponseEntity<?> studentExistException(StudentExistsException studentExistsException){
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setStatusCode(HttpStatus.OK.value());
		errorDetails.setErrorMessage(studentExistsException.getMessage());
		errorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value= {StudentNotFoundException.class})
	public ResponseEntity<?> studentNotFoundException(StudentNotFoundException studentNotFoundException){
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorDetails.setStaus(HttpStatus.NOT_FOUND.name()); 
		errorDetails.setErrorMessage(studentNotFoundException.getMessage());
		errorDetails.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
