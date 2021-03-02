package com.ikubinfo.bmi.bmiValue;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.ikubinfo.bmi.service.BmiRequest;


@Component
public class BmiValue {
	
	BmiRequest request;
	
	public BmiValue(BmiRequest request) {
		this.request=request;
	}
	
	public double getBMI(@RequestBody BmiRequest request) {
		double bmiValue = (double) (request.getWeight()/(Math.pow(request.getHeight(), 2)))*10000;
		return bmiValue;
	}
}
