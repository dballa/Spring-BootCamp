package com.ikubinfo.ioc.currencyconverter.domain;

import java.util.stream.Stream;

public enum Currency {

	LEK("ALL", 1), USD("USD", 2), EUR("EUR", 3);

	private Currency(String name, int code) {
		this.name = name;
		this.code = code;
	}

	private String name;
	private int code;

	public static Currency forCode(int code) {

		return Stream.of(Currency.values()).filter(currency -> currency.getCode() == code).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
