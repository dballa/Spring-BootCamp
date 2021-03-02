package com.ikubinfo.ioc.currencyconverter.domain.rate.request;

import com.ikubinfo.ioc.currencyconverter.domain.Currency;

public class Rate {
	private Currency fromCurrency;
	private Currency toCurrency;
	private double rate;
	
	

	public Rate(Currency fromCurrency, Currency toCurrency, double rate) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rate = rate;
	}

	public Currency getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(Currency fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public Currency getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(Currency toCurrency) {
		this.toCurrency = toCurrency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
