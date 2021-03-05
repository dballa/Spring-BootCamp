package com.salary.application.domain.request;

public class SalaryRequest {

	private double bruttoSalary;

	public double getBruttoSalary() {
		return bruttoSalary;
	}

	public void setBruttoSalary(double bruttoSalary) {
		this.bruttoSalary = bruttoSalary;
	}

	@Override
	public String toString() {
		return "SalaryRequest [bruttoSalary=" + bruttoSalary + "]";
	}

	
}
