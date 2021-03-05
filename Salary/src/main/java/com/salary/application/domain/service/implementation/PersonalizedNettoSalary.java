package com.salary.application.domain.service.implementation;

import java.util.ArrayList;

import org.springframework.context.annotation.Profile; 
import org.springframework.stereotype.Service;

import com.salary.application.domain.request.SalaryRequest;
import com.salary.application.domain.response.SalaryResponse;
import com.salary.application.domain.service.SalaryService;
import com.salary.application.domain.service.Salary;

@Service
@Profile("prod")
public class PersonalizedNettoSalary implements SalaryService {
	
	private static ArrayList<Salary> allRequests=new ArrayList<>();
	private static double sumOfSalaries;
	private Salary salary=new Salary();
	@Override
	public SalaryResponse calculateNettoSalary(SalaryRequest bruttoSalary) {
		
		SalaryResponse nettoSalary=new SalaryResponse();
		
		if(bruttoSalary.getBruttoSalary()<=30000){
			 nettoSalary.setNettoSalary(bruttoSalary.getBruttoSalary());
		}else if(bruttoSalary.getBruttoSalary()>30000 && bruttoSalary.getBruttoSalary()<150000){
			nettoSalary.setNettoSalary(bruttoSalary.getBruttoSalary()*0.87);
		}else{
			 nettoSalary.setNettoSalary(bruttoSalary.getBruttoSalary()*0.87);
		}
		
		sumOfSalaries+=nettoSalary.getNettoSalary();
		salary.setBruttoSalary(bruttoSalary);
		salary.setNettoSalary(nettoSalary);
		allRequests.add(salary);
		
		return nettoSalary;
		
	}
	@Override
	public ArrayList<Salary> allRequestsResponses(){
		return allRequests;
	}
	@Override
	public double averageNettoSalary() {
		if(allRequests.size()!=0) {
			return sumOfSalaries/allRequests.size();
		}else {
			return 0;
		}
	}
	

}

