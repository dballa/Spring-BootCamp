package com.ikubinfo.ioc.bmiconverter.domain.bmi;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.ikubinfo.ioc.bmiconverter.domain.request.BmiRequest;
import com.ikubinfo.ioc.bmiconverter.domain.response.BmiResponse;

@Component
public class BmiService {
	private BmiRequest request;
	
	public BmiService(BmiRequest request) {
		this.request=request;
	}
	
	
	public BmiResponse getBmi(BmiRequest request) {
		double bmiValue = (double) (request.getWeight()/(Math.pow(request.getHeight(), 2)))*10000;
		BmiResponse response = new BmiResponse();
		
		String bmiDesc = "";
		
		if(bmiValue < 18.5)
			bmiDesc = "Underweight";
		else if(bmiValue > 18.5 && bmiValue < 24.9)
			bmiDesc = "Normal weight";
		else if(bmiValue > 25 && bmiValue < 29.9)
			bmiDesc = "Overweight";
		else if(bmiValue > 30)
			bmiDesc = "Obesity";
		
		response.setBmi(bmiValue);
		response.setDescription(bmiDesc);
		
		return response;
	}
}
