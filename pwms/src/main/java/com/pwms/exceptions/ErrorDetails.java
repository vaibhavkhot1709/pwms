package com.pwms.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {

	private int statusCode;
	private LocalDateTime localDateTime;
	private String errorMessage;
	private String staus;
	
}
