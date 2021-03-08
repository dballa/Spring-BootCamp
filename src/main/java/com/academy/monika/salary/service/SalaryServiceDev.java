package com.academy.monika.salary.service;

import com.academy.monika.salary.model.Salary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("dev")
public class SalaryServiceDev implements SalaryService {
    public List<Salary> calculatedSalaryList = new ArrayList<>();

    public Salary getSalary(Salary salary) {
        salary.setNetValue(calculateNetValueOf(salary.getGrossValue()));
        calculatedSalaryList.add(salary);
        return salary;
    }

    @Override
    public List<Salary> getCalculatedSalariesList() {
        return calculatedSalaryList;
    }

    @Override
    public double calculateNetValueOf(double grossValue) {
        return grossValue * 0.91;
    }

    @Override
    public Salary getCalculatedMedianSalary() {
        return calculateMedianSalary(calculatedSalaryList);
    }
}
