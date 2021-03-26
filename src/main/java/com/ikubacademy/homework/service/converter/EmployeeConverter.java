package com.ikubacademy.homework.service.converter;

import com.ikubacademy.homework.service.dto.DepartmentDTO;
import com.ikubacademy.homework.service.dto.EmployeeDto;
import com.ikubacademy.homework.service.dto.EmployeeDtoForCreate;
import com.ikubacademy.homework.service.entity.EmployeeEntity;

public class EmployeeConverter {

    public static EmployeeDto toDTO(EmployeeEntity employeeEntity){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeEntity.getId());
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setDepartment(DepartmentConverter.toDepartmentDto(employeeEntity.getDepartmentEntity()));
        return employeeDto;
    }

//    public static EmployeeEntity toEntity(EmployeeDto employeeDto){
//        EmployeeEntity employeeEntity = new EmployeeEntity();
//        employeeEntity.setId(employeeEntity.getId());
//        employeeEntity.setName(employeeEntity.getName());
//        employeeEntity.setDepartmentEntity(DepartmentConverter.toDepartmentEntity(employeeDto.getDepartment()));
//        return employeeEntity;
//    }
    public static EmployeeEntity toEntity(EmployeeDtoForCreate employeeDto, DepartmentDTO departmentDTO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setJob(employeeDto.getJob());
        employeeEntity.setDepartmentEntity(DepartmentConverter.toDepartmentEntity(departmentDTO));
        return employeeEntity;
    }
}
