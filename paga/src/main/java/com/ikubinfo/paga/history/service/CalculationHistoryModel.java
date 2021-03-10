package com.ikubinfo.paga.history.service;

public class CalculationHistoryModel {
	private double request;
	private double response;

	public CalculationHistoryModel(double request, double response) {
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

	public void setResponse(double response) {
		this.response = response;
	}

}
