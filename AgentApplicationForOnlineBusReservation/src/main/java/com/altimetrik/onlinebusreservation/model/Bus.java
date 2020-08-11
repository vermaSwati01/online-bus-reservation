package com.altimetrik.onlinebusreservation.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bus_number;	
	@Column
	private String operator_name;
	@Column
	private String source_city_name; 
	@Column
	private String destination_city_name;
	
	@Column
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date departure_time;
	
	@Column
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date arrival_time;
	
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate travel_date;
	
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate return_date;
	
	@Column 
	private int price;
	
	@Column
	private int total_tickets;
	
	public Bus() {
		super();
	}

	public int getBus_number() {
		return bus_number;
	}

	public void setBus_number(int bus_name) {
		this.bus_number = bus_name;
	}

	public String getOperator_name() {
		return operator_name;
	}

	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}

	public String getSource_city_name() {
		return source_city_name;
	}

	public void setSource_city_name(String source_city_name) {
		this.source_city_name = source_city_name;
	}

	public String getDestination_city_name() {
		return destination_city_name;
	}

	public void setDestination_city_name(String destination_city_name) {
		this.destination_city_name = destination_city_name;
	}

	public Date getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Date departure_time) {
		this.departure_time = departure_time;
	}

	public Date getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(Date arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal_tickets() {
		return total_tickets;
	}

	public void setTotal_tickets(int total_tickets) {
		this.total_tickets = total_tickets;
	}
	
	public LocalDate getTravel_date() {
		return travel_date;
	}

	public void setTravel_date(LocalDate travel_date) {
		this.travel_date = travel_date;
	}

	public LocalDate getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	

	@Override
	public String toString() {
		return "Bus [bus_number=" + bus_number + ", operator_name=" + operator_name + ", source_city_name="
				+ source_city_name + ", destination_city_name=" + destination_city_name + ", departure_time="
				+ departure_time + ", arrival_time=" + arrival_time + ", price=" + price + ", total_tickets="
				+ total_tickets + "]";
	}


	
	
 

}
