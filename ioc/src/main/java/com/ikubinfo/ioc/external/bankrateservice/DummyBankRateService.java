package com.ikubinfo.ioc.external.bankrateservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("dev")
public class DummyBankRateService implements BankService {

	RestTemplate restTemplate;
	String url;

	public DummyBankRateService(@Value("${ikubinfo.appName}") String url) {
		super();
		this.url = url;
		System.out.println("Hello from dev profile");
	}

	@Override
	public RateResponse getRate(int fromCurrencyCode, int toCurrenctyCode) {
		return new RateResponse(fromCurrencyCode, toCurrenctyCode, 135);
	}

}
