package com.ikub.paymentGenerate.response;

public class PaymentResponse {
    private double netoPayment;

    public PaymentResponse(){

    }
    public PaymentResponse(double netoPayment) {
        this.netoPayment = netoPayment;
    }

    public double getNetoPayment() {
        return netoPayment;
    }

    public void setNetoPayment(double netoPayment) {
        this.netoPayment = netoPayment;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "netoPayment=" + netoPayment +
                '}';
    }
}
