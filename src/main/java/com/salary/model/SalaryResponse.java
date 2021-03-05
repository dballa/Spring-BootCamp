package com.salary.model;

public class SalaryResponse {
	private double netSalary;

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public String toString() {
		return "SalaryResponse [netSalary=" + netSalary + "]";
	}
}
