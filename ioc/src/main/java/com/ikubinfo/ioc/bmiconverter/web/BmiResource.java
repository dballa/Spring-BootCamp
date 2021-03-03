package com.ikubinfo.ioc.bmiconverter.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.ioc.bmiconverter.domain.bmi.BmiService;
import com.ikubinfo.ioc.bmiconverter.domain.request.BmiRequest;
import com.ikubinfo.ioc.bmiconverter.domain.response.BmiResponse;

@RestController
@RequestMapping("/bmi")
public class BmiResource {

	BmiService bmiService;

	public BmiResource(BmiService bmiService) {
		this.bmiService = bmiService;
	}

	@PostMapping
	private BmiResponse bmi(@RequestBody BmiRequest request) {
		System.out.println(request);
		return bmiService.getBmi(request);
	}

}
