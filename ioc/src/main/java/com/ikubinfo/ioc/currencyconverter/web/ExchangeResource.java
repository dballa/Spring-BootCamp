package com.ikubinfo.ioc.currencyconverter.web;

import com.ikubinfo.ioc.currencyconverter.domain.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.ioc.currencyconverter.domain.exchange.ExchangeService;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.ioc.currencyconverter.domain.exchange.response.ExchangeRespnse;

@RestController
@RequestMapping("/exchange")
public class ExchangeResource {

	ExchangeService exchangeService;
	@Autowired
	@Qualifier("dollar")
	CoinService coinService;
	@Autowired
	@Qualifier("euro")
	CoinService coinServiceEuro;

	public ExchangeResource(ExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}

	@PostMapping
	private ExchangeRespnse exchange(@RequestBody ExchangeRequest request) {
		System.out.println(request);
		coinService.printCoin("coin");
		coinServiceEuro.printCoin("coin");
		return exchangeService.exchange(request);
	}

}
