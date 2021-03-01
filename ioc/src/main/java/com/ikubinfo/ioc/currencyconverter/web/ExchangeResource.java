package com.ikubinfo.ioc.currencyconverter.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ikubinfo.ioc.currencyconverter.domain.exchange.ExchangeService;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.response.ExchangeRespnse;
import com.ikubinfo.ioc.currencyconverter.domain.rate.RateService;
import com.ikubinfo.ioc.external.bankrateservice.NationalBankRateService;

@RestController
@RequestMapping("/exchange")
public class ExchangeResource {

	ExchangeService exchangeService;

	public ExchangeResource() {
		super();
		//The ExchangeResource doesn't have to know about the existence of new NationalBankRateService or even new RestTemplate()
		this.exchangeService = new ExchangeService(
				new RateService(new NationalBankRateService(new RestTemplate(), "URL")));
	}

	@PostMapping
	private ExchangeRespnse exchange(@RequestBody ExchangeRequest request) {
		System.out.println(request);
		return exchangeService.exchange(request);
	}

}
