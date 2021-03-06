package com.ikub.paymentGenerate.service;

import com.ikub.paymentGenerate.request.PaymentRequest;
import com.ikub.paymentGenerate.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Profile("dev")
@Service
public class PaymentCalcService implements PaymentCalc{
        private double allNetoPayment=0;
        List<PaymentRequest> paymentRequests;
        List<PaymentResponse> paymentResponses;

    public PaymentCalcService() {
        paymentRequests=new ArrayList<>();
        paymentResponses=new ArrayList<>();
    }

    @Override
    public PaymentResponse getNetoPayement( PaymentRequest paymentRequest) {
        paymentRequests.add(paymentRequest);
        allNetoPayment=allNetoPayment+paymentRequest.getBrutoPayement();
        PaymentResponse response=new PaymentResponse();
        double value=(paymentRequest.getBrutoPayement()*0.91);
        response.setNetoPayment(value);
        paymentResponses.add(response);
        return response;
    }

    @Override
    public double getNetoAvarage() {
        return allNetoPayment/paymentRequests.size();
    }

    @Override
    public List<PaymentResponse> getAllResponse() {
        return paymentResponses;
    }



    @Override
    public List<PaymentRequest> getAllRequests() {
        return paymentRequests;
    }
}
