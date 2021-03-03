package com.ikub.bmi.bmicalculator.calculator;

import com.ikub.bmi.bmicalculator.request.BmiRequest;

public interface CalculatorBmi {

	double calculateBmi(BmiRequest request);
	
	String descriptionOfBmi(double bmi);

}