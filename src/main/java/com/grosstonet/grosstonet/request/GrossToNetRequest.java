package com.grosstonet.grosstonet.request;

public class GrossToNetRequest {

    private double amount;


    public GrossToNetRequest() {
    }

    public GrossToNetRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
