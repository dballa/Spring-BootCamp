package com.academy.monika.restapp.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private String gender;
    private String status;

}
