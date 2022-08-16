package com.example.SpringBootCamp.demo.dto;

import com.example.SpringBootCamp.demo.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MotivationDto {
    private Long id;
    private String MotivationQuote;
    private UserEntity CreatedBy;
}
