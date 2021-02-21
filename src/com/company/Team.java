package com.company;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private Person coach;
    private String strategy;
    private List <Player> players = new ArrayList<Player>();

    public Team(String name,Person coach,String strategy,List<Player> players) {
        this.name = name;
        this.coach = coach;
        this.strategy = strategy;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + name + '\'' +
                ", coachOfTeam=" + coach +
                ", strategy='" + strategy + '\'' +
                ", teamPlayers=" + players +
                '}';
    }
}
