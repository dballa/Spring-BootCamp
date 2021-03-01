package com.ikubinfo.ioc.currencyconverter.domain.rate;

import org.springframework.web.client.RestTemplate;

import com.ikubinfo.ioc.currencyconverter.domain.Currency;
import com.ikubinfo.ioc.currencyconverter.domain.rate.request.Rate;
import com.ikubinfo.ioc.external.bankrateservice.NationalBankRateService;
import com.ikubinfo.ioc.external.bankrateservice.RateResponse;

public class RateService {

	NationalBankRateService bankRateService;

	public RateService() {
		super();
		
		this.bankRateService = new NationalBankRateService();
	}

	public Rate getRate(int fromcurrencyCode, int toCurrencyCode) {

		RateResponse response = bankRateService.getRate(fromcurrencyCode, toCurrencyCode);

		Currency fromCurrency = Currency.forCode(fromcurrencyCode);
		Currency toCurrency = Currency.forCode(toCurrencyCode);
		System.out.println(String.format("Rate from %s to %s is %s", fromCurrency, toCurrency, response.getRate()));
		return new Rate(fromCurrency, toCurrency, response.getRate());

	}

}
