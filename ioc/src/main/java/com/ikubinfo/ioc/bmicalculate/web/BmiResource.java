package com.ikubinfo.ioc.bmicalculate.web;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.ioc.bmiconverter.domain.bmi.request.BmiRequest;
import com.ikubinfo.ioc.bmiconverter.domain.bmi.response.BmiRespnse;
import com.ikubinfo.ioc.bmiconverter.domain.calculate.CalculateBmi;


@RestController
@RequestMapping("/bmi")

public class BmiResource {

CalculateBmi calculateBmi;

	public BmiResource(CalculateBmi calculateBmi) {
		
		this.calculateBmi=calculateBmi;
	}
	
	@PostMapping
	private BmiRespnse response(@RequestBody BmiRequest request) {
		System.out.println(request);
		System.out.println(calculateBmi.calculate(request));
		return calculateBmi.calculate(request);
	}

}
