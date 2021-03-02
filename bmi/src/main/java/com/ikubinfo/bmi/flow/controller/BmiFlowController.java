package com.ikubinfo.bmi.flow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.bmi.service.BmiRequest;
import com.ikubinfo.bmi.service.BmiResponse;
import com.ikubinfo.bmi.service.BmiService;

@RestController
@RequestMapping("/service")
public class BmiFlowController {
	private BmiService service;
	
	public BmiFlowController(BmiService service) {
		this.service=service;
	}
	
	@GetMapping("/home")
	public String hello() {
		return "Hello";
	}
	
	@PostMapping("/bmi")
	public BmiResponse response(@RequestBody BmiRequest request) {
		System.out.println(request);
		return service.generateResponse(request);
	}
	

}
