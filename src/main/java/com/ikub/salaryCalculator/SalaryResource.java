package com.ikub.salaryCalculator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gross_to_net")
public class SalaryResource {

    @Autowired
    SalaryService service;

    @PostMapping
    private SalaryDto convertToNet(@RequestBody SalaryDto dto){
        return service.saveToDb(dto);
    }

    @GetMapping("/get_average")
    public ResponseEntity<Double> getAllNetSalariesAverage() {
        return ResponseEntity.ok(service.getNetSalariesAverage());
    }


}
