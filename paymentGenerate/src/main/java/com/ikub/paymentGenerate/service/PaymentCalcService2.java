package com.ikub.paymentGenerate.service;

import com.ikub.paymentGenerate.request.PaymentRequest;
import com.ikub.paymentGenerate.response.PaymentResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Profile("prod")
@Service
public class PaymentCalcService2 implements PaymentCalc{
    private double allNetoPayment=0;
    List<PaymentRequest> paymentRequests;
    List<PaymentResponse> paymentResponses;

    public PaymentCalcService2() {
        paymentRequests=new ArrayList<>();
        paymentResponses=new ArrayList<>();
    }

    @Override
    public PaymentResponse getNetoPayement( PaymentRequest paymentRequest) {
        paymentRequests.add(paymentRequest);
        allNetoPayment=allNetoPayment+paymentRequest.getBrutoPayement();
        PaymentResponse response=new PaymentResponse();

        if( paymentRequest.getBrutoPayement() > 0 && paymentRequest.getBrutoPayement() <= 30000 ){
            response.setNetoPayment(paymentRequest.getBrutoPayement());
        }
        else if( paymentRequest.getBrutoPayement() > 30000 && paymentRequest.getBrutoPayement() <= 150000 ) {
            response.setNetoPayment(paymentRequest.getBrutoPayement()*(1-0.13));
        }
        else if( paymentRequest.getBrutoPayement() > 150000) {
            response.setNetoPayment(paymentRequest.getBrutoPayement()*(1-0.23));
        }

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
