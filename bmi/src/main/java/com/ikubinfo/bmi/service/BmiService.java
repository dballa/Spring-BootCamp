package com.ikubinfo.bmi.service;

import org.springframework.stereotype.Service;

import com.ikubinfo.bmi.bmiValue.BmiValue;

import util.WeightStatus;

@Service
public class BmiService {
	
	BmiValue bmiValue;
	
	public BmiService(BmiValue bmiValue) {
		this.bmiValue = bmiValue;
	}

	public BmiResponse generateResponse(BmiRequest request) {
		BmiResponse response = new BmiResponse();
		double bmi = bmiValue.getBMI(request);
		if (bmi < 18.5) {
			response.setBmiValue(bmi);
			response.setDescription(WeightStatus.UNDERWEIGHT.getName());
		} else if (bmi < 24.9) {
			response.setBmiValue(bmi);
			response.setDescription(WeightStatus.NORMAL_WEIGHT.getName());
		} else if (bmi < 29.9) {
			response.setBmiValue(bmi);
			response.setDescription(WeightStatus.OVERWEIGHT.getName());
		} else if (bmi < 40) {
			response.setBmiValue(bmi);
			response.setDescription(WeightStatus.OBESITY.getName());
		}
		return response;
	}
}
