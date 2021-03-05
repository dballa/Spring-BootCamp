package com.grosstonet.grosstonet.response;

public class GrossToNetResponseDev {

    private double netAmount;

    public GrossToNetResponseDev() {
    }

    public GrossToNetResponseDev(double netAmount) {
        this.netAmount = netAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }
}
