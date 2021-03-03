package com.ikubinfo.ioc.currencyconverter.domain.rate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ikubinfo.ioc.currencyconverter.domain.Currency;
import com.ikubinfo.ioc.currencyconverter.domain.rate.request.Rate;
import com.ikubinfo.ioc.external.bankrateservice.BankService;
import com.ikubinfo.ioc.external.bankrateservice.RateResponse;

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

	@Async
	public void method() {
		System.out.println("Started long method");
		for (int i = 0; i < 15; i++) {
			System.out.println("Iteration 1");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	@Scheduled(fixedRate = 3000)
	public void scheduled() {
		System.out.println("Executing "+ new Date());
	}

}
