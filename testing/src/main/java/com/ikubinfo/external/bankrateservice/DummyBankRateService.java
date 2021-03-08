package com.ikubinfo.external.bankrateservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DummyBankRateService implements BankService {

	RestTemplate restTemplate;
	String url;

	public DummyBankRateService(@Value("${ikubinfo.appName}") String url) {
		super();
		this.url = url;
	}

	@Override
	public RateResponse getRate(int fromCurrencyCode, int toCurrenctyCode) {
		return new RateResponse(fromCurrencyCode, toCurrenctyCode, 135);
	}

	
	
}
