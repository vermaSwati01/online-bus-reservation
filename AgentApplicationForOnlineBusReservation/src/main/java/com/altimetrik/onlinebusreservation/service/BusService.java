package com.altimetrik.onlinebusreservation.service;

import java.time.LocalDate;
import java.util.List;

import com.altimetrik.onlinebusreservation.model.Bus;

public interface BusService {

	
	public List<Bus> getBusInformation(String source_city_name , String destination_city_name , LocalDate travel_date , LocalDate return_date );
}
