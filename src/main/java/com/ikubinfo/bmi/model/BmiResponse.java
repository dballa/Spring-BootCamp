package com.ikubinfo.bmi.model;

import com.ikubinfo.bmi.enums.Description;

public class BmiResponse {
    private double bmiNum;
    private Description description;

    public double getBmiNum() {
        return bmiNum;
    }

    public void setBmiNum(double bmiNum) {
        this.bmiNum = bmiNum;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
