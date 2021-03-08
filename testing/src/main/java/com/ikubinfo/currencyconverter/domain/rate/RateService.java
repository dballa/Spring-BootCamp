package com.ikubinfo.currencyconverter.domain.rate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ikubinfo.currencyconverter.domain.Currency;
import com.ikubinfo.currencyconverter.domain.rate.request.Rate;
import com.ikubinfo.external.bankrateservice.BankService;
import com.ikubinfo.external.bankrateservice.RateResponse;

@Component
public class RateService {

	BankService bankRateService;

	public RateService(@Qualifier("nationalBankRateService") BankService bankRateService) {
		super();
		this.bankRateService = bankRateService;
	}

	public Rate getRate(int fromcurrencyCode, int toCurrencyCode) {

		RateResponse response = bankRateService.getRate(fromcurrencyCode, toCurrencyCode);

		Currency fromCurrency = Currency.forCode(fromcurrencyCode);
		Currency toCurrency = Currency.forCode(toCurrencyCode);
		System.out.println(String.format("Rate from %s to %s is %s", fromCurrency, toCurrency, response.getRate()));
		return new Rate(fromCurrency, toCurrency, response.getRate());

	}

}
