package com.ikub.bmi.request;

public class BmiRequest {
    private double height;
    private double mass;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "BmiRequest{" +
                "height=" + height +
                ", mass=" + mass +
                '}';
    }
}
