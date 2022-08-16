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
public class ReviewDto {
    private Long id;
    private UserEntity createdBy;
    private boolean valid;
    private String ReviewInfo;
}
