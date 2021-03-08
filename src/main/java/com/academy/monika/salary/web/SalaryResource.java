package com.academy.monika.salary.web;

import com.academy.monika.salary.model.Salary;
import com.academy.monika.salary.service.SalaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salary")
public class SalaryResource {
    SalaryService salaryService;

    public SalaryResource(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping
    public Salary getCompleteSalary(@RequestBody Salary request) {
        return salaryService.getSalary(request);
    }

    @GetMapping
    private List<Salary> getAllSalariesCalculated() {
        return salaryService.getCalculatedSalariesList();
    }

    @GetMapping("median")
    private Salary getMedianOfAllSalariesCalculated() {
        return salaryService.getCalculatedMedianSalary();
    }

}
