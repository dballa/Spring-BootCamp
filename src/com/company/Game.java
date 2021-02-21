package com.company;

public class Game {
    private Person referee;
    private Team homeTeam;
    private Team guessTeam;

    public Game() {
        super();
    }

    public Person getReferee() {
        return referee;
    }

    public void setReferee(Person referee) {
        this.referee = referee;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getGuessTeam() {
        return guessTeam;
    }

    public void setGuessTeam(Team guessTeam) {
        this.guessTeam = guessTeam;
    }

    @Override
    public String toString() {
        return "Game{" +
                "referee=" + referee +
                ", team1=" + homeTeam +
                ", team2=" + guessTeam +
                '}';
    }


}

