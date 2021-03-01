package com.ikubinfo.ioc.currencyconverter.domain.exchange;

import com.ikubinfo.ioc.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.response.ExchangeRespnse;
import com.ikubinfo.ioc.currencyconverter.domain.rate.RateService;
import com.ikubinfo.ioc.currencyconverter.domain.rate.request.Rate;

public class ExchangeService {

	private RateService rateService;

	public ExchangeService() {
		super();
//Removed the constructor parameters from RateService
		this.rateService = new RateService();
	}

	public ExchangeRespnse exchange(ExchangeRequest request) {

		Rate rate = rateService.getRate(request.getOriginalCurrency().getCode(), request.getTargetCurrency().getCode());

		ExchangeRespnse response = new ExchangeRespnse();
		response.setAmount(request.getAmount() * rate.getRate());
		response.setCurrency(request.getTargetCurrency());
		return response;

	}

}
