package com.example.spring.Flow;


import com.example.spring.Inputs.BmiRequest;
import com.example.spring.Inputs.BmiResponse;
import com.example.spring.Inputs.BmiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class BmiFlow {
    private BmiService service;

    public BmiFlow(BmiService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/bmi")
    public BmiResponse response(@RequestBody BmiRequest request) {
        System.out.println(request);
        return service.generateResponse(request);
    }
}

