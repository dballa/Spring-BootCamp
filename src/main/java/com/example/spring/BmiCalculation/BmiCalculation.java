package com.example.spring.BmiCalculation;

import com.example.spring.Inputs.BmiRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class BmiCalculation {
    BmiRequest request;

    public BmiCalculation(BmiRequest request) {
        this.request = request;
    }

    public double getBmi(@RequestBody BmiRequest request) {
        double bmiValue = (double) (request.getWeight()) / (Math.pow(request.getHeight(), 2)) * 1000;
        return bmiValue;
    }
}
