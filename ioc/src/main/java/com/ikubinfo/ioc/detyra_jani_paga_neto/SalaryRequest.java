package com.ikubinfo.ioc.detyra_jani_paga_neto;

import org.springframework.stereotype.Component;

@Component
public class SalaryRequest {

    private int salaryBruto;


    public int getSalaryBruto() {
        return salaryBruto;
    }

    public void setSalaryBruto(int salaryBruto) {
        this.salaryBruto = salaryBruto;
    }
}
