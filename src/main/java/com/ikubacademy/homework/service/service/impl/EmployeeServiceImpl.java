package com.ikubacademy.homework.service.service.impl;

import com.ikubacademy.homework.service.converter.DepartmentConverter;
import com.ikubacademy.homework.service.converter.EmployeeConverter;
import com.ikubacademy.homework.service.dto.EmployeeDtoForCreate;
import com.ikubacademy.homework.service.entity.DepartmentEntity;
import com.ikubacademy.homework.service.entity.EmployeeEntity;
import com.ikubacademy.homework.service.exceptions.DepartmentException;
import com.ikubacademy.homework.service.exceptions.EmployeeException;
import com.ikubacademy.homework.service.reposritory.DepartmentRepository;
import com.ikubacademy.homework.service.reposritory.EmployeeRepository;
import com.ikubacademy.homework.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public EmployeeEntity addEmployee(EmployeeDtoForCreate employeeDtoForCreate) throws Exception{
        if (employeeRepository.existsEmployee(employeeDtoForCreate.getName(),employeeDtoForCreate.getJob())){
            throw new EmployeeException("Employee already exists");
        }
        if (!departmentRepository.existsDepartment(employeeDtoForCreate.getDepartmentId()))
            throw new DepartmentException("Department not found");

        DepartmentEntity departmentEntity = departmentRepository.getDepartmentFromId(employeeDtoForCreate.getDepartmentId());
        EmployeeEntity employeeEntity = EmployeeConverter.toEntity(employeeDtoForCreate,
                                                                            DepartmentConverter.toDepartmentDto(departmentEntity));
        employeeRepository.addEmployee(employeeEntity);

        return employeeEntity;
    }

    @Override
    public EmployeeEntity getEmployee(Long id) {
        return employeeRepository.getEmployee(id);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
