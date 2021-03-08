package com.academy.monika.salary.service;


import com.academy.monika.salary.model.Salary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("prod")
public class SalaryServiceProd implements SalaryService {
    public List<Salary> calculatedSalaryList=new ArrayList<>();

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
        double socialServiceValue=0.095*grossValue;
        double healthServiceValue=0.017*grossValue;
        double tap=0;

        if(grossValue>30000 && grossValue<=150000){
            if(grossValue>114670){
                socialServiceValue=0.095*114670;
            }else {
                socialServiceValue=0.095*grossValue;
            }
            tap=grossValue*0.13;
        }else if(grossValue>150000){
            socialServiceValue=0.095*114670;
            tap=15600+(0.23*(grossValue-150000));
        }

        return grossValue-socialServiceValue-healthServiceValue-tap;
    }

    @Override
    public Salary getCalculatedMedianSalary() {
        return calculateMedianSalary(calculatedSalaryList);
    }

    public List<Salary> getCalculatedSalaryList() {
        return calculatedSalaryList;
    }
}