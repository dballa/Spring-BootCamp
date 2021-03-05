package com.salary.model;

public class SalaryRequest {
	private double grossSalary;

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	@Override
	public String toString() {
		return "SalaryRequest [grossSalary=" + grossSalary + "]";
	}
}
