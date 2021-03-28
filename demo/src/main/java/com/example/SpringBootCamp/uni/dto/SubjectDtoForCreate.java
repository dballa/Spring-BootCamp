package com.example.SpringBootCamp.uni.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubjectDtoForCreate {
    private String name;
    private boolean active;
    private Double creditsCfu;
    private Integer semester;
    private Double total_hours;
    private Long professorId;
}
