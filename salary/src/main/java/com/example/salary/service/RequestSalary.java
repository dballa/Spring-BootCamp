package com.example.salary.service;

public class RequestSalary {

	private double gross;

	
	
	public RequestSalary() {
		super();
	}

	public RequestSalary(double gross) {
		super();
		this.gross = gross;
	}

	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}

	@Override
	public String toString() {
		return "Request [gross=" + gross + "]";

	}

}
