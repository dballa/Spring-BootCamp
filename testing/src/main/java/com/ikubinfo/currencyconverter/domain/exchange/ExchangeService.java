package com.ikubinfo.currencyconverter.domain.exchange;

import org.springframework.stereotype.Service;

import com.ikubinfo.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.currencyconverter.domain.exchange.response.ExchangeRespnse;
import com.ikubinfo.currencyconverter.domain.rate.RateService;
import com.ikubinfo.currencyconverter.domain.rate.request.Rate;

@Service
public class ExchangeService {

	private RateService rateService;

	public ExchangeService(RateService rateService) {
		super();
		this.rateService = rateService;
	}

	public ExchangeRespnse exchange(ExchangeRequest request) {

		Rate rate = rateService.getRate(request.getOriginalCurrency().getCode(), request.getTargetCurrency().getCode());

		ExchangeRespnse response = new ExchangeRespnse();
		response.setAmount(request.getAmount() * rate.getConversionRate());
		response.setCurrency(request.getTargetCurrency());
		return response;

	}

}
