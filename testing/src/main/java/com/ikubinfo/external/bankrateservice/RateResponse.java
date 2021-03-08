package com.ikubinfo.external.bankrateservice;

public class RateResponse {

	private int fromCurrencyCode;
	private int toCurrencyCode;
	private double rate;
	
	
	public RateResponse(int fromCurrencyCode, int toCurrencyCode, double rate) {
		super();
		this.fromCurrencyCode = fromCurrencyCode;
		this.toCurrencyCode = toCurrencyCode;
		this.rate = rate;
	}


	public int getFromCurrencyCode() {
		return fromCurrencyCode;
	}


	public void setFromCurrencyCode(int fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}


	public int getToCurrencyCode() {
		return toCurrencyCode;
	}


	public void setToCurrencyCode(int toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}
	
	

}
