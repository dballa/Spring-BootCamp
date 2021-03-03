package com.example.BMI.response;

import org.springframework.stereotype.Component;


public class BmiResponse {
    private double value;
    private String description;

    public BmiResponse() {
    }
    public BmiResponse(double value,String description){
        this.value=value;
        this.description=description;
    }

    @Override
    public String toString() {
        return "BmiResponse{" +
                "value=" + value +
                ", description='" + description + '\'' +
                '}';
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
