package com.altimetrik.onlinebusreservation.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.onlinebusreservation.exception.BusNotAvailableException;
import com.altimetrik.onlinebusreservation.exception.InformationNotFoundException;
import com.altimetrik.onlinebusreservation.model.Bus;
import com.altimetrik.onlinebusreservation.repository.BusDao;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	public BusDao busDAO;

	@Override
	@Transactional
	public List<Bus> getBusInformation(String source_city_name, String destination_city_name, LocalDate travel_date,
			LocalDate return_date) {
		// TODO Auto-generated method stub
		if (source_city_name == null || destination_city_name == null || travel_date == null) {
			throw new InformationNotFoundException("Please check Entries required paramter missing");
		} else {

			List<Bus> bus = busDAO.getBusInformation(source_city_name, destination_city_name, travel_date, return_date);

			if (bus.isEmpty()) {
				throw new BusNotAvailableException("Bus is not available for the given details");
			} else {
				return bus;
			}

		}
	}

}
