package com.bmi.app.calculation;

import org.springframework.stereotype.Component;

import com.bmi.app.services.BmiRequest;

@Component
public class CalculateBmi {

	public double getBMI(BmiRequest request) {
		return (request.getWeight() / (Math.pow(request.getHeight(), 2))) * 10000;
	}
}
