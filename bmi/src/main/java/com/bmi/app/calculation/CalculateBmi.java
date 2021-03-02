package com.bmi.app.calculation;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.bmi.app.services.BmiRequest;

@Component
public class CalculateBmi {
	
	BmiRequest request;
	
	public CalculateBmi(BmiRequest request) {
		this.request=request;
	}
	
	public double getBMI(@RequestBody BmiRequest request) {
		double bmiValue = (double) (request.getWeight()/(Math.pow(request.getHeight(), 2)))*10000;
		return bmiValue;
	}
}
