package com.income.wages.response;


public class GrossToNetResponseProd {

    private double grossIncome;
  
    private double socialInsurance;
    private double healthInsurance;
    private double netIncome;
    private double tax;


    public GrossToNetResponseProd() {
		
	}

	public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    

    public double getSocialInsurance() {
        return socialInsurance;
    }

    public void setSocialInsurance(double socialInsurance) {
        this.socialInsurance = socialInsurance;
    }

    public double getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(double healthInsurance) {
        this.healthInsurance = healthInsurance;
    }


    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }


    public double getNetIncome() {
        return netIncome;
    }

    public double setNetIncome(double netIncome) {
        return netIncome;
    }
    @Override
    public String toString() {
        return "GrossToNetResponseProd {" +
                "netIncome=" + netIncome +
                ", socialInsurance=" + socialInsurance +
                ", healthInsurance=" + healthInsurance +
                ", tax=" + tax +
                '}';
    }
    
}
