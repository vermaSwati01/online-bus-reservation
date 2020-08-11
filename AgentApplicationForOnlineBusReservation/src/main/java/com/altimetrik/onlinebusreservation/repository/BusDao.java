package com.altimetrik.onlinebusreservation.repository;

import java.time.LocalDate;
import java.util.List;

import com.altimetrik.onlinebusreservation.model.Bus;

public interface BusDao {
	
	public List<Bus> getBusInformation(String source_city_name , String destination_city_name , LocalDate travel_date , LocalDate return_date);

}
