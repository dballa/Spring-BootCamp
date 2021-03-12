package com.example.spring.Inputs;

import com.example.spring.BmiCalculation.BmiCalculation;
import com.example.spring.WeightStatus.WeightStatus;
import org.springframework.stereotype.Service;


@Service
public class BmiService {

    BmiCalculation bmiCalculation;

    public BmiService(BmiCalculation bmiCalculation) {
        this.bmiCalculation = bmiCalculation;
    }

    public BmiResponse generateResponse(BmiRequest request) {
        BmiResponse response = new BmiResponse();
        double bmi = bmiCalculation.getBmi(request);
        if (bmi < 18.5) {
            response.setBmiValue(bmi);
            response.setDescription(WeightStatus.UNDERWEIGHT.getName());
        } else if (bmi < 24.9) {
            response.setBmiValue(bmi);
            response.setDescription(WeightStatus.NORMAL_WEIGHT.getName());
        } else if (bmi < 29.9) {
            response.setBmiValue(bmi);
            response.setDescription(WeightStatus.OVERWEIGHT.getName());
        } else if (bmi < 40) {
            response.setBmiValue(bmi);
            response.setDescription(WeightStatus.OBESITY.getName());
        }
        return response;
    }
}
