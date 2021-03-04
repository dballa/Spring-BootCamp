package com.payment.app.util;

public enum CalculationCoefficients {
	
	HEALTH_INSURANCE("HEALTH_INSURANCE", 0.017), SOCIAL_INSURANCE("SOCIAL_INSURANCE", 0.095), MEDIUM_INCOME_TAX("MEDIUM_INCOME_TAX", 0.13), HIGH_INCOME_TAX("HIGH_INCOME_TAX", 0.23);
	
	private String name;
	private double coeff;
	
	private CalculationCoefficients(String name, double coeff) {
		this.name = name;
		this.coeff = coeff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

}
