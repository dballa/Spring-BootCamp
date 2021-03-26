package com.ikubacademy.homework.service.converter;

import com.ikubacademy.homework.service.dto.DepartmentDTO;
import com.ikubacademy.homework.service.dto.DepartmentDtoCreate;
import com.ikubacademy.homework.service.entity.DepartmentEntity;

public class DepartmentConverter {

    public static DepartmentEntity toDepartmentEntity(DepartmentDtoCreate departmentDtoCreate){
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(departmentDtoCreate.getName());
        return departmentEntity;
    }
    public static DepartmentDTO toDepartmentDto(DepartmentEntity departmentEntity){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(departmentEntity.getId());
        departmentDTO.setName(departmentEntity.getDepartmentName());
        return departmentDTO;
    }
}
