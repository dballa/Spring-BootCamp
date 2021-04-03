package com.ikubinfo.products.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MoneyExchange {
	private String base;
	private double results;
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public double getResults() {
		return results;
	}
	public void setResults(double results) {
		this.results = results;
	}

}
