package com.ikubacademy.homework.service.controller;

import com.ikubacademy.homework.service.converter.EmployeeConverter;
import com.ikubacademy.homework.service.dto.EmployeeDto;
import com.ikubacademy.homework.service.dto.EmployeeDtoForCreate;
import com.ikubacademy.homework.service.entity.EmployeeEntity;
import com.ikubacademy.homework.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public EmployeeDto addEmployee(@RequestBody EmployeeDtoForCreate employeeDto) throws Exception {
       return EmployeeConverter.toDTO(employeeService.addEmployee(employeeDto));
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id){
        return EmployeeConverter.toDTO(employeeService.getEmployee(id));
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
