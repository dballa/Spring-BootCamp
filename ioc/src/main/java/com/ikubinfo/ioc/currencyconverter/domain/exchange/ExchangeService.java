package com.ikubinfo.ioc.currencyconverter.domain.exchange;

import org.springframework.web.client.RestTemplate;

import com.ikubinfo.ioc.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.response.ExchangeRespnse;
import com.ikubinfo.ioc.currencyconverter.domain.rate.RateService;
import com.ikubinfo.ioc.currencyconverter.domain.rate.request.Rate;
import com.ikubinfo.ioc.external.bankrateservice.NationalBankRateService;

public class ExchangeService {

	private RateService rateService;

	public ExchangeService() {
		super();
		// still ExchangeService know/sees implementation details about rate service and
		// also NationalBankRateService and RestTemplate
		this.rateService = new RateService(new NationalBankRateService(new RestTemplate(), "URL"));
	}

	public ExchangeRespnse exchange(ExchangeRequest request) {

		Rate rate = rateService.getRate(request.getOriginalCurrency().getCode(), request.getTargetCurrency().getCode());

		ExchangeRespnse response = new ExchangeRespnse();
		response.setAmount(request.getAmount() * rate.getRate());
		response.setCurrency(request.getTargetCurrency());
		return response;

	}

}
