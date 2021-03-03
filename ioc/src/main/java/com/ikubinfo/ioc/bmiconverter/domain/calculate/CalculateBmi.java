package com.ikubinfo.ioc.bmiconverter.domain.calculate;
import com.ikubinfo.ioc.bmiconverter.domain.Bmi;
import com.ikubinfo.ioc.bmiconverter.domain.bmi.request.BmiRequest;

import org.springframework.stereotype.Service;


import com.ikubinfo.ioc.bmiconverter.domain.bmi.response.BmiRespnse;


@Service
public class CalculateBmi{

public Bmi calculate(BmiRequest request)  {
	
	BmiRespnse response = new BmiRespnse();
	double heightInMeter = request.getHeight() / 100;
	response.setBmi(request.getWeight() / (heightInMeter * heightInMeter));
	
	
	if (response.getBmi()<18.5)
	{
		response.setDescription(Bmi.UNDERWEIGHT);
	}
	else if (response.getBmi()>18.5 && response.getBmi()<24.9)
	{
		response.setDescription(Bmi.NORMALWEIGHT);
	}
	else if(response.getBmi()>25.0 && response.getBmi()<29.9)
	{
		response.setDescription(Bmi.OVERWEIGHT);
	}
	else
	{
		response.setDescription(Bmi.OBESITY);
	}

	return response;
}



}
