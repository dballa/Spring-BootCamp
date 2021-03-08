package com.ikubinfo.currencyconverter.domain.rate.request;

import com.ikubinfo.currencyconverter.domain.Currency;

public class Rate {
	private Currency fromCurrency;
	private Currency toCurrency;
	private double conversionRate;

	public Rate(Currency fromCurrency, Currency toCurrency, double conversionRate) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionRate = conversionRate;
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

	public double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

}
