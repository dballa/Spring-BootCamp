package com.ikubinfo.seanca11.usermanagement.model;

import java.time.LocalDateTime;


public class Reservations {
	
	
	private Users username;
	private Services service;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	

	public Reservations(Users username, Services service, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.username = username;
		this.service = service;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	

	public Users getUsername() {
		return username;
	}

	public void setUsername(Users username) {
		this.username = username;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public Services getService() {
		return service;
	}


	public void setService(Services service) {
		this.service = service;
	}

	

}
