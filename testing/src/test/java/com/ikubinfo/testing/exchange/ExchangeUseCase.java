package com.ikubinfo.testing.exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ikubinfo.currencyconverter.domain.Currency;
import com.ikubinfo.currencyconverter.domain.exchange.ExchangeService;
import com.ikubinfo.currencyconverter.domain.exchange.request.ExchangeRequest;
import com.ikubinfo.currencyconverter.domain.exchange.response.ExchangeRespnse;
import com.ikubinfo.currencyconverter.domain.rate.RateService;
import com.ikubinfo.currencyconverter.domain.rate.request.Rate;

public class ExchangeUseCase {

	private ExchangeService exchangeService;
	private RateService rateService;

	@BeforeEach
	public void initializeBeforeAllTestMethods() {
		rateService = Mockito.mock(RateService.class);
		exchangeService = new ExchangeService(rateService);
	}

	@Test
	public void successfullExchange() {
		double amount = 100;

		Rate rate = new Rate(Currency.EUR, Currency.LEK, 134);

		when(rateService.getRate(rate.getFromCurrency().getCode(), rate.getToCurrency().getCode())).thenReturn(rate);

		ExchangeRequest request = new ExchangeRequest();
		request.setAmount(amount);
		request.setOriginalCurrency(rate.getFromCurrency());
		request.setTargetCurrency(rate.getToCurrency());

		ExchangeRespnse response = exchangeService.exchange(request);
		assertNotNull(response);
		assertEquals(response.getAmount(), amount * rate.getConversionRate());
		assertEquals(rate.getToCurrency(), response.getCurrency());

	}

	@Test
	public void unsuccessfullExchange() {
		double amount = -1;

		Rate rate = new Rate(Currency.EUR, Currency.LEK, 134);

		ExchangeRequest request = new ExchangeRequest();
		request.setAmount(amount);
		request.setOriginalCurrency(rate.getFromCurrency());
		request.setTargetCurrency(rate.getToCurrency());

		Exception exception = assertThrows(IllegalArgumentException.class, () -> exchangeService.exchange(request));

		assertEquals(exception.getMessage(), "Amount should be greater then 0");

	}

}
