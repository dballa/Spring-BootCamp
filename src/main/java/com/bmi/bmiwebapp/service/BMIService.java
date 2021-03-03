package com.bmi.bmiwebapp.service;

import com.bmi.bmiwebapp.enums.BMICategory;
import com.bmi.bmiwebapp.request.BMIRequest;
import com.bmi.bmiwebapp.response.BMIResponse;
import org.springframework.stereotype.Service;

@Service
public class BMIService {

    public BMIResponse generateBMIResponse(BMIRequest bmi) {
        double bmiValue = bmi.generateBMI();

        if(bmiValue < 18.5) {
            return new BMIResponse(bmiValue, BMICategory.UNDERWEIGHT.getFieldDescription());
        } else if (bmiValue > 18.5 && bmiValue < 24.9) {
            return new BMIResponse(bmiValue, BMICategory.NORMAL_WEIGHT.getFieldDescription());
        } else if (bmiValue > 25.0 && bmiValue < 29.9) {
            return new BMIResponse(bmiValue, BMICategory.OVERWEIGHT.getFieldDescription());
        } else {
            return new BMIResponse(bmiValue, BMICategory.OBESITY.getFieldDescription());
        }
    }

}
