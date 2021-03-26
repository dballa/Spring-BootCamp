package com.ikubacademy.homework.service.service.impl;

import com.ikubacademy.homework.service.converter.DepartmentConverter;
import com.ikubacademy.homework.service.dto.DepartmentDTO;
import com.ikubacademy.homework.service.dto.DepartmentDtoCreate;
import com.ikubacademy.homework.service.entity.DepartmentEntity;
import com.ikubacademy.homework.service.reposritory.DepartmentRepository;
import com.ikubacademy.homework.service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO addDepartment(DepartmentDtoCreate departmentDtoCreate) {
        DepartmentEntity departmentEntity = departmentRepository.addDepartment(DepartmentConverter.toDepartmentEntity(departmentDtoCreate));
        return DepartmentConverter.toDepartmentDto(departmentEntity);
    }

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.getAllEntities();
    }

    @Override
    public DepartmentDTO getDepartment(String name) {
        return DepartmentConverter.toDepartmentDto(departmentRepository.getDepartment(name));
    }

    @Override
    public DepartmentDTO getDepartment(Long id) {
        return DepartmentConverter.toDepartmentDto(departmentRepository.getDepartmentFromId(id));
    }
}
