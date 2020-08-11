package com.altimetrik.onlinebusreservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InformationNotFoundException extends RuntimeException{
	
	public InformationNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
