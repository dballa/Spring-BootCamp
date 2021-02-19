package com.company;

import util.Strategyes;


public class Team {
    private String teamName;
    private Coach coachOfTeam;
    private Person players;
    private Strategyes strategy;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Coach getCoachOfTeam() {
        return coachOfTeam;
    }

    public void setCoachOfTeam(Coach coachOfTeam) {
        this.coachOfTeam = coachOfTeam;
    }

    public Person getPlayers() {
        return players;
    }

    public void setPlayers(Person players) {
        this.players = players;
    }

    public Strategyes getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategyes strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", coachOfTeam=" + coachOfTeam +
                ", players=" + players +
                ", strategy=" + strategy +
                '}';
    }
}
