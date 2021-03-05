package com.salary.application.domain.service.implementation;

import java.util.ArrayList;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.salary.application.domain.request.SalaryRequest;
import com.salary.application.domain.response.SalaryResponse;
import com.salary.application.domain.service.Salary;
import com.salary.application.domain.service.SalaryService;

@Service
@Profile("dev")
public class NormalNettoSalary implements SalaryService {
	
	private static ArrayList<Salary> allRequests=new ArrayList<>();
	private static double sumOfSalaries;
	private Salary salary=new Salary();
	
	@Override
	public SalaryResponse calculateNettoSalary(SalaryRequest bruttoSalary) {
		
		SalaryResponse nettoSalary=new SalaryResponse();
		
		nettoSalary.setNettoSalary(bruttoSalary.getBruttoSalary()*91);
		
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
