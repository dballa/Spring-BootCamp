package com.payment.app.service;

public class Response {
	private double neto;

	public double getNeto() {
		return neto;
	}

	public void setNeto(double neto) {
		this.neto = neto;
	}

	@Override
	public String toString() {
		return "Response [neto=" + neto + "]";
	}

}
