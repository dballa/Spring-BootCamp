package com.ikub.paymentGenerate.controller;

import com.ikub.paymentGenerate.request.PaymentRequest;
import com.ikub.paymentGenerate.response.PaymentResponse;
import com.ikub.paymentGenerate.service.PaymentCalc;
import com.ikub.paymentGenerate.service.PaymentCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class PaymentController {
    @Autowired
    PaymentCalc paymentCalcService;


    @PostMapping("/payment")
    public PaymentResponse response(@RequestBody PaymentRequest paymentRequest) {
        return paymentCalcService.getNetoPayement(paymentRequest);
    }

    @GetMapping("/requests")
    public List<PaymentRequest> getRequests(){
        return paymentCalcService.getAllRequests();
    }
    @GetMapping("/responses")
    public List<PaymentResponse> getResponses(){
        return paymentCalcService.getAllResponse();
    }
}