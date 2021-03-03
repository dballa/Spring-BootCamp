package com.ikubinfo.ioc.bmi;

public interface BmiService {

	double calculateBmi(double  height ,double weight);
	
	String translateBmiValue(double bmi);
	
}
