package com.example.salary.service;

public class ResponseSalary {
	
	private double net;
	
	

	public ResponseSalary() {
		super();
	}

	public ResponseSalary(double net) {
		super();
		this.net = net;
	}

	public double getNet() {
		return net;
	}

	public void setNet(double net) {
		this.net = net;
	}

	@Override
	public String toString() {
		return "Response [net=" + net + "]";
	}
}
