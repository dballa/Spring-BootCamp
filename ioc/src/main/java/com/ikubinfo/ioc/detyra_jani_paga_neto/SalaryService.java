package com.ikubinfo.ioc.detyra_jani_paga_neto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SalaryService {
    public SalaryResponse response(SalaryRequest request) {
        double sum = 0;
        int count = 0;
        double avgSalary = 0;
        ArrayList <Double> salaries = new ArrayList<>();

        double salaryNet = request.getSalaryBruto() * 0.91;
        salaries.add(salaryNet);

        //TO DO business logic

        for (int i = 0; i < salaries.size(); i++) {
            count++;
            sum+= salaryNet;
            avgSalary = sum / count;

        }

        SalaryResponse response = new SalaryResponse();
        response.setSalaryNet(salaryNet);
        response.setAvgSalary(avgSalary);
        return response;
    }

}

