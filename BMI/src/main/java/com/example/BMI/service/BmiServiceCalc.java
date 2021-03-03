package com.example.BMI.service;

import com.example.BMI.request.BmiRequest;
import com.example.BMI.response.BmiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BmiServiceCalc {

    BmiService service;

    public double calculate (double weight,double height) {
        return (weight / (Math.pow(height, 2)));
    }
    public String getBmi(double value){
        BmiResponse response=new BmiResponse();
        if (value < 18.5) {
            response.setDescription("Underweight");
        } else if (value < 24.9) {
            response.setDescription("Normal Weight");
        } else if (value < 29.9) {
            response.setDescription("Overweight");
        } else if (value > 29.9) {
            response.setDescription("Obesity");
        }
        response.setValue(value);
        return response.toString();
    }

}
