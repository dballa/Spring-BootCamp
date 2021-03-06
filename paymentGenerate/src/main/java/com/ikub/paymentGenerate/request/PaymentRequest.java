package com.ikub.paymentGenerate.request;

public class PaymentRequest {
    private double brutoPayement;

    public PaymentRequest(){

    }

    public PaymentRequest(double brutoPayement) {
        this.brutoPayement = brutoPayement;
    }

    public double getBrutoPayement() {
        return brutoPayement;
    }

    public void setBrutoPayement(double brutoPayement) {
        this.brutoPayement = brutoPayement;
    }

    @Override
    public String toString() {
        return "PayementRequest{" +
                "brutoPayement=" + brutoPayement +
                '}';
    }
}
