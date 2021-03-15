package com.ikubinfo.seanca11.usermanagement.model;

import java.util.List;

public class Services {
	
	private String serviceName;
	private String description;
	private double price;
	private List<Reservations> reservations ; 
	
	
	public Services(String serviceName, String description, double price) {
		super();
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
		
	}
	public Services(List<Reservations> reservations) {
		this.reservations=reservations;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public List<Reservations> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}
	

}
