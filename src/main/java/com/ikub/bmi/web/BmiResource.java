package com.ikub.bmi.web;


import com.ikub.bmi.BmiService;
import  com.ikub.bmi.request.BmiRequest;
import com.ikub.bmi.response.BmiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmi")
public class BmiResource {
    @Autowired
    BmiService bmiService;

    public BmiResource(BmiService service){
        this.bmiService = service;
    }
    @PostMapping
    private BmiResponse calculate(@RequestBody BmiRequest request){
        System.out.println(request);
        return bmiService.calculate(request);
    }
}
