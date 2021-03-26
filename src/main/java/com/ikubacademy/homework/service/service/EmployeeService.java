package com.ikubacademy.homework.service.service;

import com.ikubacademy.homework.service.dto.EmployeeDtoForCreate;
import com.ikubacademy.homework.service.entity.EmployeeEntity;
import com.ikubacademy.homework.service.exceptions.DepartmentException;
import com.ikubacademy.homework.service.exceptions.EmployeeException;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity addEmployee(EmployeeDtoForCreate employeeDtoForCreate) throws EmployeeException, DepartmentException, Exception;
    EmployeeEntity getEmployee(Long id);
    List<EmployeeEntity> getAllEmployees();
}
