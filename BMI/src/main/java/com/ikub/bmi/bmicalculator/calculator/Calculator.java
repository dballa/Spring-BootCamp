package com.ikub.bmi.bmicalculator.calculator;

import org.springframework.stereotype.Component;

import com.ikub.bmi.bmicalculator.request.BmiRequest;

@Component
public class Calculator implements CalculatorBmi {
	
	BmiRequest request;
	
	public Calculator(BmiRequest request) {
		
		this.request=request;
	}
	
	@Override
	public double calculateBmi(BmiRequest request){
		
		return request.getWeight()/(Math.pow(request.getHeight(), 2));
	}
	
	@Override
	public String descriptionOfBmi(double bmi)
	{
		String description="";
		
		if (bmi < 18.5) {
			description="Underweight";
		} else if (bmi>18.5 && bmi < 24.9) {
			description="Normal Weight";
		} else if (bmi>24.9 && bmi < 29.9) {
			description="Overweight";
		} else {
			description="Obesity";
		}
		
		return description;
	}

}
