package com.ikub.BarberApp.model;

public enum TypeOfReservation {
 TYPE1("An Exceptional Haircut"),
    TYPE2("Shampoo & Condition"),
    TYPE3("Relaxing Hot Towel"),
    TYPE4("Eyebrow & Mustache Trim"),
    TYPE5("Free Neck Trim");
    String description;

    TypeOfReservation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
