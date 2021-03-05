package com.salary.application.domain.service;

import java.util.ArrayList;

import com.salary.application.domain.request.SalaryRequest;
import com.salary.application.domain.response.SalaryResponse;

public interface SalaryService {
	
	SalaryResponse calculateNettoSalary(SalaryRequest bruttoSalary);
	ArrayList <Salary> allRequestsResponses();
	double averageNettoSalary();

}
