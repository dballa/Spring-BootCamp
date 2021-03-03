package com.bmi.bmiwebapp.request;

public class BMIRequest {

    private double height;
    private double weight;

    public BMIRequest(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double generateBMI() {
        return weight / Math.pow(height, 2);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
