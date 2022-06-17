package com.ikubinfo.ioc.BMI;

import org.springframework.stereotype.Service;

@Service
public class BMIService {
    public BmiResponse response(BmiRequest request) {


        double bmi = request.getWeight() / request.getHeight() * request.getHeight();
        String description;
        if (bmi <= 18.5) {
            description = "Underweight";
        } else if (bmi >= 18.6 && bmi <= 24.9) {
            description = "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            description = "Overweight";
        } else description = "Obesity";

        BmiResponse response = new BmiResponse();
        response.setBmi(bmi);
        response.setDescription(description);
        return response;

    }

}

