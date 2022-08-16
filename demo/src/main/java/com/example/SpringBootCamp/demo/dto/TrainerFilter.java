package com.example.SpringBootCamp.demo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class TrainerFilter {
    private long id;
    private String firstName;
    @NotBlank(message = "Firstname is mandatory")
    private String LastName;
    private String sortBy;
    private String order;

    public TrainerFilter(String firstName, String lastName,String sortBy,String order) {
    }
}
