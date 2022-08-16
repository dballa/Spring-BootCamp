package com.example.SpringBootCamp.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MembershipInfoDto {
    private Long id;
    private String description;
    private LocalDate StartDate;
    private LocalDate EndDate;
    private Boolean Valid;
}
