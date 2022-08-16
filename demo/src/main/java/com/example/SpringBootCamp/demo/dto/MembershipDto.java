package com.example.SpringBootCamp.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MembershipDto {
    private Long id;
    private String membership;
    private int count;
    private int fee;
}
