package com.ikubinfo.currencyconverter.domain.exchange.request;

import com.ikubinfo.currencyconverter.domain.Currency;

public class ExchangeRequest {

	private double amount;
	private Currency originalCurrency;
	private Currency targetCurrency;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(Currency originalCurrency) {
		this.originalCurrency = originalCurrency;
	}

	public Currency getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(Currency targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	@Override
	public String toString() {
		return "ExchangeRequest [amount=" + amount + ", originalCurrency=" + originalCurrency + ", targetCurrency="
				+ targetCurrency + "]";
	}

}
