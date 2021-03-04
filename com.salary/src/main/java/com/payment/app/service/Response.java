package com.payment.app.service;

public class Response {
	private double net;

	public double getNetSalary() {
		return net;
	}

	public void setNetSalary(double net) {
		this.net = net;
	}

	@Override
	public String toString() {
		return "Response [net=" + net + "]";
	}

}
