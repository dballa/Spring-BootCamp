package com.example.spring.WeightStatus;

public enum WeightStatus {

    UNDERWEIGHT("UNDERWEIGHT", 1), NORMAL_WEIGHT("NORMAL_WEIGHT", 2), OVERWEIGHT("OVERWEIGHT", 3), OBESITY("OBESITY", 4);

    private WeightStatus(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return id;
    }

    public void setCode(int id) {
        this.id = id;
    }

}
