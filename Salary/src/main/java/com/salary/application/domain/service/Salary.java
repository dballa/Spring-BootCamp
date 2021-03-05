package com.salary.application.domain.service;

import com.salary.application.domain.request.SalaryRequest;
import com.salary.application.domain.response.SalaryResponse;

public class Salary {
	
	SalaryRequest bruttoSalary;
	SalaryResponse nettoSalary;
	
	public SalaryRequest getBruttoSalary() {
		return bruttoSalary;
	}
	public void setBruttoSalary(SalaryRequest bruttoSalary) {
		this.bruttoSalary = bruttoSalary;
	}
	public SalaryResponse getNettoSalary() {
		return nettoSalary;
	}
	public void setNettoSalary(SalaryResponse nettoSalary) {
		this.nettoSalary = nettoSalary;
	}
	@Override
	public String toString() {
		return "Salary [bruttoSalary=" + bruttoSalary + ", nettoSalary="+nettoSalary+"]";
	}
	
	

}
