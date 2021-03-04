package com.payment.app.service;

public class Request {
	
	private double gross;

	public double getGrossSalary() {
		return gross;
	}

	public void setGrossSalary(double gross) {
		this.gross = gross;
	}

	@Override
	public String toString() {
		return "Request [gross=" + gross + "]";
	}

}
