package com.ikub.paga.response;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class SalaryResponseDev {
    private double salaryNeto;

    public double getSalaryNeto() {
        return salaryNeto;
    }

    public void setSalaryNeto(double salaryNeto) {
        this.salaryNeto = salaryNeto;
    }

    @Override
    public String toString() {
        return "SalaryResponse{" +
                "salaryNeto=" + salaryNeto +
                '}';
    }
}
