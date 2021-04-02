package com.academy.monika.restapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfessorDto {
    private Long id;
    private String firstName;
    private String lastName;
}
