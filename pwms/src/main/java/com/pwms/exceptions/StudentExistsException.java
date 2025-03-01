package com.pwms.exceptions;

@SuppressWarnings("serial")
public class StudentExistsException extends RuntimeException {

	public StudentExistsException(String message) {
		super(message);
	}
}
