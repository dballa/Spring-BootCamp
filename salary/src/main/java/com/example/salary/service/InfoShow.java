package com.example.salary.service;

public class InfoShow {
	private double request;
	private double response;
	
	
	public InfoShow() {
		super();
	}
	
	public InfoShow(double request, double response) {
		super();
		this.request = request;
		this.response = response;
	}
	public double getRequest() {
		return request;
	}
	public void setRequest(double request) {
		this.request = request;
	}
	public double getResponse() {
		return response;
	}
	public void setResponse(int response) {
		this.response = response;
	}
	
	
}
