package com.company;

import util.Positions;
import util.Roles;
import util.Strategyes;


//You are asked to manage the football game.
//        The game has a referee, a place where it will be played and two teams that will play.
//        Each  team has players and a coach who can set different types of positions/strategies for the team.
//        Create a basic data modeling of the application.
//        Feel free to add additional stuff in the application.
public class Main {

    public static void main(String[] args) {

        Game game1 = new Game();
        Team team1 = new Team();
        Team team2 = new Team();

        team1.setTeamName("RM");
        team2.setTeamName("Liverpool");

        Person referee = new Person();
        referee.setName("Goku");
        referee.setAge(45);
        referee.setRole(Roles.Referee);


        Coach coach1 = new Coach("Sasuke",team1,Roles.Coach);
        Player player1 = new Player("p1",20,Roles.Player,team1,Positions.Attacker);
        Player player2 = new Player("p2",20,Roles.Player,team1,Positions.Goalkeeper);


        Coach coach2 = new Coach("Naruto",team2,Roles.Coach);
        Player player3 = new Player("p1",20,Roles.Player,team1,Positions.Midfielder);
        Player player4 = new Player("p2",20,Roles.Player,team1,Positions.Defender);

        game1.setTeam1(team1);
        game1.setTeam2(team1);
        game1.setReferee(referee);

        team1.setCoachOfTeam(coach1);
        team1.setStrategy(Strategyes.Attack);

        team2.setCoachOfTeam(coach2);
        team2.setStrategy(Strategyes.Defend);


        System.out.println(player1.getName());
        System.out.println(game1.toString());
        System.out.println(player1.toString());

    }
}
