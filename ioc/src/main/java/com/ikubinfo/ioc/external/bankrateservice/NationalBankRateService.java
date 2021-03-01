package com.ikubinfo.ioc.external.bankrateservice;

import org.springframework.web.client.RestTemplate;

public class NationalBankRateService {

	RestTemplate restTemplate;
	String url;

	public NationalBankRateService() {
		super();
		this.restTemplate = new RestTemplate();// this seems easy but we could have more complex initialization
		this.url = "URL"; // but the requirements will be to read this from some property files or system
							// variables;
	}

	public RateResponse getRate(int fromCurrencyCode, int toCurrenctyCode) {
		return new RateResponse(fromCurrencyCode, toCurrenctyCode, randDouble(124, 149));
	}

	public double randDouble(double bound1, double bound2) {
		// make sure bound2> bound1
		double min = Math.min(bound1, bound2);
		double max = Math.max(bound1, bound2);
		// math.random gives random number from 0 to 1
		return min + (Math.random() * (max - min));
	}

}
