package com.ikubacademy.homework.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class EmployeeDtoForCreate {
    private String name;
    private String job;
    private Long departmentId;
}
