package com.ikubinfo.ioc.currencyconverter.domain.rate;

import org.springframework.stereotype.Component;

import com.ikubinfo.ioc.currencyconverter.domain.Currency;
import com.ikubinfo.ioc.currencyconverter.domain.rate.request.Rate;
import com.ikubinfo.ioc.external.bankrateservice.BankService;
import com.ikubinfo.ioc.external.bankrateservice.RateResponse;

@Component
public class RateService {

	BankService bankRateService;

	public RateService(BankService bankRateService) {
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
