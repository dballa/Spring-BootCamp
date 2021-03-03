package com.ikubinfo.ioc.external.bankrateservice;

public interface BankService {

	RateResponse getRate(int fromCurrencyCode, int toCurrenctyCode);

}