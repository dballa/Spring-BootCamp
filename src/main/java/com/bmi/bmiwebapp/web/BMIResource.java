package com.bmi.bmiwebapp.web;

import com.bmi.bmiwebapp.response.BMIResponse;
import com.bmi.bmiwebapp.request.BMIRequest;
import com.bmi.bmiwebapp.service.BMIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIResource {

    private final BMIService bmiService;

    public BMIResource(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @PostMapping("/bmi")
    public BMIResponse bmiResponse(@RequestBody BMIRequest bmiRequest) {
        return bmiService.generateBMIResponse(bmiRequest);
    }
}
