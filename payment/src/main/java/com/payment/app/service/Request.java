package com.payment.app.service;

public class Request {
	private double bruto;

	public double getBruto() {
		return bruto;
	}

	public void setBruto(double bruto) {
		this.bruto = bruto;
	}

	@Override
	public String toString() {
		return "Request [bruto=" + bruto + "]";
	}

}
