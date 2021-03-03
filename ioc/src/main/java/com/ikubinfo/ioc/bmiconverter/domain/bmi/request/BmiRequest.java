package com.ikubinfo.ioc.bmiconverter.domain.bmi.request;

import org.springframework.stereotype.Component;

@Component
public class BmiRequest {

	private double height;
	private double weight;


	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "BmiRequest [ height=" + height + ", weight=" + weight + "]";
	}

}
