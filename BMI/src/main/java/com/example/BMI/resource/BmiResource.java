package com.example.BMI.resource;

import com.example.BMI.request.BmiRequest;
import com.example.BMI.response.BmiResponse;
import com.example.BMI.service.BmiService;
import com.example.BMI.service.BmiServiceCalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmi")
public class BmiResource {
    @Autowired
    BmiServiceCalc bmiService;

    @PostMapping()
    public BmiResponse response(@RequestBody BmiRequest bmiRequest){
        double value= bmiService.calculate(bmiRequest.getWeight(),bmiRequest.getHeight());
        String description = bmiService.getBmi(value);
        return new BmiResponse(value,description);
    }
}
