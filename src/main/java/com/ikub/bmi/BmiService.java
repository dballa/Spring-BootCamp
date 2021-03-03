package com.ikub.bmi;

import com.ikub.bmi.request.BmiRequest;
import com.ikub.bmi.response.BmiResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BmiService {

    public BmiResponse calculate(BmiRequest request){
        double value = request.getMass()/Math.pow(request.getHeight(),2);
        BmiResponse response = new BmiResponse();
        response.setBmi(value);
        if (value<=18.5){
            response.setState("Underweight");
        } else if (value>18.5 && value<=24.9){
            response.setState("Normal weight");
        } else if (value>=25 && value<29.9){
            response.setState("Overweight");
        }else {
            response.setState("Obesity");
        }
        return response;
    }
}
