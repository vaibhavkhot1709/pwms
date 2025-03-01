package com.pwms.exceptions;

@SuppressWarnings("serial")
public class ListOfStudentsExistsException extends RuntimeException {

	public ListOfStudentsExistsException(String message) {
		super(message);
	}
}
