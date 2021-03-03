package com.ikubinfo.bmi.web;

import com.ikubinfo.bmi.model.BmiRequest;
import com.ikubinfo.bmi.model.BmiResponse;
import com.ikubinfo.bmi.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class BmiResource {

    BmiService bmiService;

    @Autowired
    public BmiResource(BmiService bmiService) {
        this.bmiService = bmiService;
    }

    @PostMapping
    private BmiResponse calculateBmi(@RequestBody BmiRequest request){
        System.out.println(request);
        return bmiService.calculateBmi(request);
    }
}
