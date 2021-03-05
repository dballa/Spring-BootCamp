package com.salary.application.domain.response;

public class SalaryResponse {
	
	private double nettoSalary;

	public double getNettoSalary() {
		return nettoSalary;
	}

	public void setNettoSalary(double netoSalary) {
		this.nettoSalary = netoSalary;
	}

	@Override
	public String toString() {
		return "SalaryResponse [nettoSalary=" + nettoSalary + "]";
	}

}
