package com.example.salary.service;

import java.util.List;

public interface SalaryInterface {
	
	
	 public double getAllNetoAvarage();
	 public ResponseSalary getResponseNeto(RequestSalary requestSalary);
	 public List <InfoShow> getInfo() ;
	
}
