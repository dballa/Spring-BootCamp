package com.example.demo.web.request;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.Service;

public class CreateReservationRequest {
	private String email;
	private String serviceName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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
}
