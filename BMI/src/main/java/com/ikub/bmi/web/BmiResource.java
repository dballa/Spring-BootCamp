package com.ikub.bmi.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikub.bmi.bmicalculator.BmiService;
import com.ikub.bmi.bmicalculator.request.BmiRequest;
import com.ikub.bmi.bmicalculator.response.BmiResponse;

@RestController
@RequestMapping("/bmi")
public class BmiResource {
	
	BmiService bmiService;
	
	public BmiResource(BmiService bmiService) {
		
		this.bmiService=bmiService;
	}
	
	@PostMapping
	private BmiResponse bmi(@RequestBody BmiRequest request) {
		System.out.println(request);
		System.out.println(bmiService.bmi(request));
		return bmiService.bmi(request);
	}

}
