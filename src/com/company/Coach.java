package com.company;

import util.Roles;

public class Coach extends Person {
    private String name;
    private Roles role;

    public Coach(String name,Team team,Roles role) {
        this.name = name;
        this.role = role;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
