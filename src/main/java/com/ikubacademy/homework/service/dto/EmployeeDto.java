package com.ikubacademy.homework.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;
    private String name;
    private String job;
    private DepartmentDTO department;
}
