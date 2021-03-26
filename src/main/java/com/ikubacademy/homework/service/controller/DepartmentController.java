package com.ikubacademy.homework.service.controller;

import com.ikubacademy.homework.service.dto.DepartmentDTO;
import com.ikubacademy.homework.service.dto.DepartmentDtoCreate;
import com.ikubacademy.homework.service.entity.DepartmentEntity;
import com.ikubacademy.homework.service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDtoCreate departmentDtoCreate){
        return departmentService.addDepartment(departmentDtoCreate);
    }
    @GetMapping("/getAllDepartments")
    public List<DepartmentEntity> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
    @GetMapping
    @RequestMapping("/{name}")
    public DepartmentDTO getDep(@PathVariable String name){
        return departmentService.getDepartment(name);
    }

}
