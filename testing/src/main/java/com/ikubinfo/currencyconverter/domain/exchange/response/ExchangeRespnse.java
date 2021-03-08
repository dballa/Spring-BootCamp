package com.ikubinfo.currencyconverter.domain.exchange.response;

import com.ikubinfo.currencyconverter.domain.Currency;

public class ExchangeRespnse {

	private double amount;
	private Currency currency;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
