package com.bmi.bmiwebapp.enums;
public enum BMICategory {
    UNDERWEIGHT("Underweight"),
    NORMAL_WEIGHT("Normal weight"),
    OVERWEIGHT("Overweight"),
    OBESITY("Obesity");

    private final String fieldDescription;

    BMICategory(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
