package com.academy.monika.salary.service;


import com.academy.monika.salary.model.Salary;

import java.util.List;

public interface SalaryService {
    Salary getSalary(Salary salary);

    List<Salary> getCalculatedSalariesList();

    double calculateNetValueOf(double grossValue);
    Salary getCalculatedMedianSalary();

    default Salary calculateMedianSalary(List<Salary> allSalaries) {
        double sum = 0;
        for (Salary salary : allSalaries) {
            sum += salary.getNetValue();
        }
        Salary medianSalary = new Salary();
        medianSalary.setNetValue(sum/allSalaries.size());
        return medianSalary;
    }

    ;
}
