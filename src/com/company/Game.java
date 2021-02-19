package com.company;

public class Game {
    private Person referee;
    private Team team1;
    private Team team2;

    public Game(){
        super();
    }

    public void setReferee(Person referee) {
        this.referee = referee;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return "Game{" +
                "referee=" + referee +
                ", team1=" + team1 +
                ", team2=" + team2 +
                '}';
    }


}

