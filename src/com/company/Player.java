package com.company;

import util.Positions;
import util.Roles;

public class Player extends Person {
    private String name;
    private int Age;
    private Roles role;
    private Team team;
    private Positions playerPosition;

    public Player(String name,int age,Roles role,Team team,Positions playerPosition) {
        super();
        this.name = name;
        Age = age;
        this.role = role;
        this.team = team;
        this.playerPosition = playerPosition;
    }

    @Override
    public Roles getRole() {
        return role;
    }

    @Override
    public void setRole(Roles role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Positions getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Positions playerPosition) {
        this.playerPosition = playerPosition;
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
    public int getAge() {
        return Age;
    }

    @Override
    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                ", role=" + role +
                ", team=" + team +
                ", playerPosition=" + playerPosition +
                '}';
    }
}
