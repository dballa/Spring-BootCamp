package com.ikubinfo.ioc.external.bankrateservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NationalBankRateService {

	RestTemplate restTemplate;
	String url;

	public NationalBankRateService(RestTemplate restTemplate, @Value("${ikubinfo.appName}") String url) {
		super();
		this.restTemplate = restTemplate;
		this.url = url;
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
