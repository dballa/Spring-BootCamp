package com.academy.rest.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@Getter
//@JsonSerialize
public class Error {
    private final String errorName;
    private final LocalDateTime localDateTime;
    private final String possibleSolution;
}
