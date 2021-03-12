package com.example.spring.Inputs;

import org.springframework.stereotype.Component;

@Component
public class BmiRequest {
    private double height;
    private double weight;

    @Override
    public String toString() {
        return "Request [height=" + height + ", weight=" + weight + "]";
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
