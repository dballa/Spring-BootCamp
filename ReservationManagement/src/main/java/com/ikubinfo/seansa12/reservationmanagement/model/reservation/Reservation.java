package com.ikubinfo.seansa12.reservationmanagement.model.reservation;

import java.time.LocalDateTime;

import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;
import com.ikubinfo.seansa12.reservationmanagement.model.user.User;

public class Reservation {
	
	private User user;
	private Services service;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String code;
	
	
	public Reservation(User user, Services service, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.user = user;
		this.service = service;
		this.startTime = startTime;
		this.endTime = endTime;
		this.code = service.getCode()+startTime.toString()+endTime.toString();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Services getService() {
		return service;
	}
	public void setService(Services service) {
		this.service = service;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
