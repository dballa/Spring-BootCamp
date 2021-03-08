package com.income.wages.request;

public class GrossToNetRequest {

    private double grossIncome;


    public GrossToNetRequest() {
    }

    public GrossToNetRequest(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }
    
    @Override
    public String toString() {
        return "GrossToNetRequest{" +
                "gossIncome=" + grossIncome +
                '}';
    }

	
}
