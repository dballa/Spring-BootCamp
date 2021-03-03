package com.ikubinfo.ioc.bmi;

public class BmiIndex {
	private double bmi;
	private String description;

	public BmiIndex(double bmi, String description) {
		super();
		this.bmi = bmi;
		this.description = description;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
