package com.salary.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.salary.model.SalaryRequest;
import com.salary.model.SalaryResponse;

@Component
@Profile("prod")
public class SalaryServiceProd implements SalaryService{

	public SalaryResponse calculateNet(SalaryRequest request) {
		SalaryResponse response = new SalaryResponse();
		
		double grossSalary = request.getGrossSalary();
		
		if( grossSalary > 0 && grossSalary <= 30000 ){
			response.setNetSalary(grossSalary);
		}
		else if( grossSalary > 30000 && grossSalary <= 150000 ) {
			response.setNetSalary(grossSalary*(1-0.13));
		}
		else if( grossSalary > 150000) {
			response.setNetSalary(grossSalary*(1-0.23));
		}
		
		return response;
	}
}
