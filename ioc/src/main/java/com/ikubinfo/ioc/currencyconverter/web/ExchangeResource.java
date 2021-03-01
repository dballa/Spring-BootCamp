package com.ikubinfo.ioc.currencyconverter.web;

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

	public ExchangeResource(ExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}

	@PostMapping
	private ExchangeRespnse exchange(@RequestBody ExchangeRequest request) {
		System.out.println(request);
		return exchangeService.exchange(request);
	}

}
