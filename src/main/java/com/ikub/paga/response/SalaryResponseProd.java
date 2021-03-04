package com.ikub.paga.response;

import org.springframework.context.annotation.Profile;

@Profile("prod")
public class SalaryResponseProd {

    private double salaryNeto;
    private double socialInsuracne;
    private double healthInsurance;
    private double tatimi;

    public double getSocialInsuracne() {
        return socialInsuracne;
    }

    public double getTatimi() {
        return tatimi;
    }

    public void setTatimi(double tatimi) {
        this.tatimi = tatimi;
    }

    public void setSocialInsuracne(double socialInsuracne) {
        this.socialInsuracne = socialInsuracne;
    }

    public double getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(double healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public double getSalaryNeto() {
        return salaryNeto;
    }

    public void setSalaryNeto(double salaryNeto) {
        this.salaryNeto = salaryNeto;
    }

    @Override
    public String toString() {
        return "ResponseProd{" +
                "salaryNeto=" + salaryNeto +
                ", socialInsuracne=" + socialInsuracne +
                ", healthInsurance=" + healthInsurance +
                ", tatimi=" + tatimi +
                '}';
    }

}
