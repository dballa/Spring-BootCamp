package footballGame;

import java.util.Date;

public class Game {
	
	private Person referee;
	private String place;
	private Date date;
	
	private Team team1;
	private Team team2;
	
	public Person getReferee() {
		return referee;
	}
	public void setReferee(Person referee) {
		this.referee = referee;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
