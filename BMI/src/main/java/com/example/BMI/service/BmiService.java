package com.example.BMI.service;

import org.springframework.stereotype.Component;

public interface BmiService {
    double calculate (double weight,double height);
    String getBmi(double value);
}
