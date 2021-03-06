package com.ikub.paymentGenerate.service;

import com.ikub.paymentGenerate.request.PaymentRequest;
import com.ikub.paymentGenerate.response.PaymentResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface PaymentCalc {

    public PaymentResponse getNetoPayement(@RequestBody PaymentRequest request);
    public List<PaymentRequest> getAllRequests();
    public List<PaymentResponse> getAllResponse();
    public double getNetoAvarage();
}
