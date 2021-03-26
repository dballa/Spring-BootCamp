package com.ikubacademy.homework.service.dto;

import com.ikubacademy.homework.service.entity.EmployeeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HolidayDto {

    private Long id;

    private int daySpan;

    private EmployeeEntity employeeEntity;
}
