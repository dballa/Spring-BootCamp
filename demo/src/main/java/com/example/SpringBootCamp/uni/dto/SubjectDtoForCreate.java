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
    private Long id;
    private String name;
    private boolean active;
    private Double creditsCfu;
    private Long semester;
    private Double total_hours;
    private String professorId;
}
