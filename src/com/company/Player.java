package com.company;

import util.Positions;
import util.Roles;

public class Player extends Person {

    private Positions playerPosition;

    public Player(String name,int age,Roles role,Team team,Positions playerPosition) {
        super(name,age,role);
        this.playerPosition = playerPosition;
    }

    public Positions getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Positions playerPosition) {
        this.playerPosition = playerPosition;
    }

    @Override
    public String toString() {
        return "Player{" +
                ", Position=" + playerPosition +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", role=" + getRole() +
                '}';
    }
}
