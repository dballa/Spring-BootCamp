package com.ikubinfo.bmi.service;

import com.ikubinfo.bmi.Description;
import com.ikubinfo.bmi.model.BmiRequest;
import com.ikubinfo.bmi.model.BmiResponse;
import org.springframework.stereotype.Component;

@Component
public class BmiService {
    public BmiResponse calculateBmi(BmiRequest request) {

        BmiResponse response = new BmiResponse();
        if (request.getHeight() <= 0 || request.getWeight() <= 0) {
            response.setDescription(Description.WRONG_INSERTED_DATA);

        }else {

            response.setBmiNum(request.getWeight() / (request.getHeight() * request.getHeight()));
            if (response.getBmiNum()<=0) {
                response.setDescription(Description.WRONG_INSERTED_DATA);
            } else if (response.getBmiNum() > 0 && response.getBmiNum() < 18.5) {
                response.setDescription(Description.UNDERWEIGHT);
            } else if (response.getBmiNum() >= 18.5 && response.getBmiNum() < 25) {
                response.setDescription(Description.NORMAL_WEIGHT);
            } else if (response.getBmiNum() >= 25 && response.getBmiNum() < 30) {
                response.setDescription(Description.OVERWEIGHT);
            } else {
                response.setDescription(Description.OBESITY);
            }
        }

        return response;
    }
}
