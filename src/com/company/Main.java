package com.company;

import util.Positions;
import util.Roles;

import java.util.ArrayList;


//You are asked to manage the football game.
//        The game has a referee, a place where it will be played and two teams that will play.
//        Each  team has players and a coach who can set different types of positions/strategies for the team.
//        Create a basic data modeling of the application.
//        Feel free to add additional stuff in the application.
public class Main {

    public static void main(String[] args) {

        Game game1 = new Game();
        Team team1 = new Team("team2",new Person("Bledi",32,Roles.Coach),"Atack",new ArrayList<>());
        Team team2 = new Team("team2",new Person("Bledi",32,Roles.Coach),"Atack",new ArrayList<>());

//        team1.setName("RM");
//        team2.setName("Liverpool");

        Person referee = new Person("Goku",1000,Roles.Referee);

        Person coachOfHomeTeam = new Person("Sasuke",50,Roles.Coach);
        Player player1 = new Player("p1",20,Roles.Player,team1,Positions.Attacker);
        Player player2 = new Player("p2",20,Roles.Player,team1,Positions.Goalkeeper);

        Person coachOfGuessTeam = new Person("Naruto",50,Roles.Coach);
        Player player3 = new Player("p1",20,Roles.Player,team1,Positions.Midfielder);
        Player player4 = new Player("p2",20,Roles.Player,team1,Positions.Defender);

        game1.setHomeTeam(team1);
        game1.setGuessTeam(team2);
        game1.setReferee(referee);

        team1.setCoach(coachOfHomeTeam);
        team1.setStrategy("Attack");

        team2.setCoach(coachOfGuessTeam);
        team2.setStrategy("Defend");

        team1.addPlayer(player1);
        System.out.println();
        System.out.println(player1.getName());
        System.out.println(game1.toString());
        System.out.println(player1.toString());

    }
}
