package com.ikubinfo.external.bankrateservice;

public interface BankService {

	RateResponse getRate(int fromCurrencyCode, int toCurrenctyCode);

}