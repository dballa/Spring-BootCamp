package com.ikubinfo.bmi;

public enum Description {
    UNDERWEIGHT("",1),
    NORMAL_WEIGHT("Normal Weight",2),
    OVERWEIGHT("Overweight",3),
    OBESITY("Obesity",4),
    WRONG_INSERTED_DATA("Wrong inserted data", 5);
    private String name;
    private Integer index;

    Description(String name,Integer index) {
        this.name=name;
        this.index=index;
    }
}
