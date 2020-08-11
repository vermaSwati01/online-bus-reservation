package com.altimetrik.onlinebusreservation.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.altimetrik.onlinebusreservation.model.Bus;
import com.altimetrik.onlinebusreservation.service.BusService;

@RestController
@Validated
public class MainSearchController {

	@Autowired
	public BusService service;

	@GetMapping("/bus/search")
	public List<Bus> findBus(@RequestParam(required = true) @NotEmpty String source_city_name,
			@RequestParam(required = true) @NotEmpty String destination_city_name , @RequestParam(required = true)  @DateTimeFormat(pattern="dd-MM-yyyy") 
	LocalDate travel_date , @RequestParam(required = false) @DateTimeFormat(pattern="dd-MM-yyyy")  LocalDate return_date ) {
		List<Bus> bus = service.getBusInformation(source_city_name, destination_city_name, travel_date , return_date);
		return bus;
	}
	
	
	  @ExceptionHandler(ConstraintViolationException.class)
	  public ResponseEntity<?> error(ConstraintViolationException constraintViolationException) {
	  
	  return ResponseEntity.badRequest().body(constraintViolationException.
	  getLocalizedMessage());
	  
	  }
	 
	 

}
