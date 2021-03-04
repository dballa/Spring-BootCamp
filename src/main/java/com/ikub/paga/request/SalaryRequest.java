package com.ikub.paga.request;


public class SalaryRequest {
    private double salaryBruto;

    public double getSalaryBruto() {
        return salaryBruto;
    }

    public void setSalaryBruto(double salaryBruto) {
        this.salaryBruto = salaryBruto;
    }

    @Override
    public String toString() {
        return "SalaryRequest{" +
                "salary=" + salaryBruto +
                '}';
    }
}
