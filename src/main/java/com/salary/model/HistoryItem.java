package com.salary.model;

public class HistoryItem {
	private double netSalary;
	private double grossSalary;
	
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	@Override
	public String toString() {
		return "HistoryItem [netSalary=" + netSalary + ", grossSalary=" + grossSalary + "]";
	}
}
