package com.bmi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmi.app.services.BmiService;
import com.bmi.app.services.BmiRequest;
import com.bmi.app.services.BmiResponse;

@RestController
@RequestMapping
public class BmiController {
	
	private BmiService service;
	@Autowired
	public BmiController(BmiService service) {
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
