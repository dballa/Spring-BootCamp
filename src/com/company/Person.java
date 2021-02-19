package com.company;

import util.Roles;


public class Person {
    private String name;
    private int Age;
    private Roles role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Perosn{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                ", role=" + role +
                '}';
    }
}
