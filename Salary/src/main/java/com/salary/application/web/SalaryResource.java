package com.salary.application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salary.application.domain.request.SalaryRequest;
import com.salary.application.domain.response.SalaryResponse;
import com.salary.application.domain.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryResource {
	
	SalaryService calculator;
	
	@Autowired
	private SalaryResource(SalaryService calculator) {
		super();
		this.calculator = calculator;
	}
	
	@GetMapping
	private SalaryResponse response(@RequestBody SalaryRequest bruttoSalary) {
		System.out.println(calculator.allRequestsResponses().toString());
		System.out.println(calculator.averageNettoSalary());
		return calculator.calculateNettoSalary(bruttoSalary);
	}

}
