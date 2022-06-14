package com.ikubinfo.ioc.bmi;

import org.springframework.stereotype.Component;

@Component
public class BmiImpl implements BmiService{

    @Override
    public double calculateBmi(double height, double weight) {

        return weight/(height*height);
    }

    @Override
    public String translateBmiValue(double bmi) {
        if (bmi <=18.5){
            return "Underweight";
        }
        else if(bmi>=18.6 && bmi<=24.9){
            return "Normal Weight";
        }else if (bmi>=25 && bmi<=29.9){
            return "Overweight";
        }else
            return "Obesity";

    }
}
