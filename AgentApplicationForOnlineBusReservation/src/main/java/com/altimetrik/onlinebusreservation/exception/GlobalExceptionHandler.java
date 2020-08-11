package com.altimetrik.onlinebusreservation.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InformationNotFoundException.class)
	public ResponseEntity<?> InformationNotFoundException(InformationNotFoundException exception , WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),exception.getMessage(), request.getDescription(false) );
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusNotAvailableException.class)
	public ResponseEntity<?> BusNotFoundException(BusNotAvailableException exception , WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),exception.getMessage(), request.getDescription(false) );
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception , WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),exception.getMessage(), request.getDescription(false) );
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
