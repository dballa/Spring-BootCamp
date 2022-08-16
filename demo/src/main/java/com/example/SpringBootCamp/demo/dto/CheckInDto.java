package com.example.SpringBootCamp.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CheckInDto {
    private Long id;
    private int times;
    private  int count;

}
