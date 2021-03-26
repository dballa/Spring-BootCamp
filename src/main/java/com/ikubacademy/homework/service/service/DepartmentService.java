package com.ikubacademy.homework.service.service;

import com.ikubacademy.homework.service.dto.DepartmentDTO;
import com.ikubacademy.homework.service.dto.DepartmentDtoCreate;
import com.ikubacademy.homework.service.entity.DepartmentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public DepartmentDTO addDepartment(DepartmentDtoCreate departmentDtoCreate);
    public List<DepartmentEntity> getAllDepartments();
    public DepartmentDTO getDepartment(String name);
}
