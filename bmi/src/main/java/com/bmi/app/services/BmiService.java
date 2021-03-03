package com.bmi.app.services;

import org.springframework.stereotype.Service;

import com.bmi.app.calculation.CalculateBmi;

@Service
public class BmiService {
	CalculateBmi calculateBmi;

	public BmiService(CalculateBmi calculateBmi) {
		this.calculateBmi = calculateBmi;
	}

	public BmiResponse generateResponse(BmiRequest request) {
		BmiResponse response = new BmiResponse();
		double bmi = calculateBmi.getBMI(request);
		if (bmi < 18.5) {
			response.setDescription("Underweight");
		} else if (bmi < 24.9) {
			response.setDescription("Normal Weight");
		} else if (bmi < 29.9) {
			response.setDescription("Overweight");
		} else if (bmi > 29.9) {
			response.setDescription("Obesity");
		}
		response.setBmiValue(bmi);
		return response;
	}
}
