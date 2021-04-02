package com.academy.monika.restapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubjectDtoForCreate {
    @NotBlank(message="Name is mandatory")
    private String name;
    private Boolean active;
    @Min(value=0, message="Minimal cfu value is 0")
    private Double creditsCfu;
    @Min(value=1, message="Minimal cfu value is 1")
    @Min(value=2, message="Maximum cfu value is 2")
    private Integer semester;
    private Double total_hours;
    private Long professorId;
}
