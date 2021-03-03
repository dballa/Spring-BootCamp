package com.bmi.bmiwebapp.response;

public class BMIResponse {

    private double bmi;
    private String description;

    public BMIResponse(double bmi, String description) {
        this.bmi = bmi;
        this.description = description;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
