package footballGame;

import java.util.List;

import footballGame.util.Strategy;

public class Team {

	private String teamName;
	private List<Player> players;
	private Person coach;
	private Strategy strategy;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public Person getCoach() {
		return coach;
	}
	public void setCoach(Person coach) {
		this.coach = coach;
	}
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	
}
