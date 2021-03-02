package com.bmi.app.services;

public class BmiResponse {
	private double bmiValue;
	private String description;

	@Override
	public String toString() {
		return "Response [bmiValue=" + bmiValue + ", description=" + description + "]";
	}

	public double getBmiValue() {
		return bmiValue;
	}

	public void setBmiValue(double bmiValue) {
		this.bmiValue = bmiValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
