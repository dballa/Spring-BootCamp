package com.ikub.bmi.bmicalculator;

import org.springframework.stereotype.Service;

import com.ikub.bmi.bmicalculator.calculator.CalculatorBmi;
import com.ikub.bmi.bmicalculator.request.BmiRequest;
import com.ikub.bmi.bmicalculator.response.BmiResponse;

@Service
public class BmiService {
	
	private CalculatorBmi calculator;
	
	public BmiService(CalculatorBmi calculator) {
		
		 this.calculator=calculator;
		 
	}
	
	public BmiResponse bmi(BmiRequest request) {
		
		BmiResponse response=new BmiResponse();
		response.setBmi(calculator.calculateBmi(request));
		response.setDescription(calculator.descriptionOfBmi(response.getBmi()));
		return response;
		
	}

}
