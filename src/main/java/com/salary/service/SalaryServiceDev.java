package com.salary.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.salary.model.SalaryRequest;
import com.salary.model.SalaryResponse;

@Component
@Profile("dev")
public class SalaryServiceDev implements SalaryService{

	public SalaryResponse calculateNet(SalaryRequest request) {
		SalaryResponse response = new SalaryResponse();
		
		response.setNetSalary(request.getGrossSalary() * 0.91);
		
		return response;
	}
}
