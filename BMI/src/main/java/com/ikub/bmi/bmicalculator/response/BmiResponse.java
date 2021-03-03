package com.ikub.bmi.bmicalculator.response;

public class BmiResponse {
	
	private double bmi;
	private String description;
	
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
	@Override
	public String toString() {
		return "BmiResponse [bmi=" + bmi + ", description=" + description + "]";
	}
	
	
	

}
