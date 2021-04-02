package com.academy.monika.restapp.dto;

import com.academy.monika.restapp.entity.ProfessorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubjectDto {
    private Long id;
    private String name;
    private boolean active;
    private Double creditsCfu;
    private Integer semester;
    private Double total_hours;
    private ProfessorEntity professor;
}
