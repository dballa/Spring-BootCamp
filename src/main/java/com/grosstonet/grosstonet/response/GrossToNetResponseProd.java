package com.grosstonet.grosstonet.response;

public class GrossToNetResponseProd {

    private double gross;
    private double socialContribution;
    private double socialInsurance;
    private double healthInsurance;
    private double socialInsuranceEmployer;
    private double healthInsuranceEmployer;
    private double pit; // Personal income tax
    private double costOfEmployment;
    private double netAmount;

    public GrossToNetResponseProd(double gross, double socialContribution, double socialInsurance, double healthInsurance, double socialInsuranceEmployer, double healthInsuranceEmployer, double pit, double costOfEmployment, double netAmount) {
        this.gross = gross;
        this.socialContribution = socialContribution;
        this.socialInsurance = socialInsurance;
        this.healthInsurance = healthInsurance;
        this.socialInsuranceEmployer = socialInsuranceEmployer;
        this.healthInsuranceEmployer = healthInsuranceEmployer;
        this.pit = pit;
        this.costOfEmployment = costOfEmployment;
        this.netAmount = netAmount;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getSocialContribution() {
        return socialContribution;
    }

    public void setSocialContribution(double socialContribution) {
        this.socialContribution = socialContribution;
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

    public double getSocialInsuranceEmployer() {
        return socialInsuranceEmployer;
    }

    public void setSocialInsuranceEmployer(double socialInsuranceEmployer) {
        this.socialInsuranceEmployer = socialInsuranceEmployer;
    }

    public double getHealthInsuranceEmployer() {
        return healthInsuranceEmployer;
    }

    public void setHealthInsuranceEmployer(double healthInsuranceEmployer) {
        this.healthInsuranceEmployer = healthInsuranceEmployer;
    }

    public double getPit() {
        return pit;
    }

    public void setPit(double pit) {
        this.pit = pit;
    }

    public double getCostOfEmployment() {
        return costOfEmployment;
    }

    public void setCostOfEmployment(double costOfEmployment) {
        this.costOfEmployment = costOfEmployment;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }
}
