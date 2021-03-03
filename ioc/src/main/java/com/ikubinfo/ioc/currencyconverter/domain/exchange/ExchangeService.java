package com.ikubinfo.ioc.currencyconverter.domain.exchange;

import org.springframework.stereotype.Service;

import com.ikubinfo.ioc.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.response.ExchangeRespnse;
import com.ikubinfo.ioc.currencyconverter.domain.rate.RateService;
import com.ikubinfo.ioc.currencyconverter.domain.rate.request.Rate;

@Service
public class ExchangeService {

	private RateService rateService;

	public ExchangeService(RateService rateService) {
		super();
		this.rateService = rateService;
	}

	public ExchangeRespnse exchange(ExchangeRequest request) {

		Rate rate = rateService.getRate(request.getOriginalCurrency().getCode(), request.getTargetCurrency().getCode());

		System.out.println("Calling long method");
		rateService.method();
		
		System.out.println("End call long method");
		
		ExchangeRespnse response = new ExchangeRespnse();
		response.setAmount(request.getAmount() * rate.getRate());
		response.setCurrency(request.getTargetCurrency());
		return response;

	}

}
