package footballGame;

import footballGame.util.Position;
import footballGame.util.Role;
import footballGame.util.Strategy;

public class Coach extends Person{
	
	private String name;
	private String surname;
	private Role role;
	private Team team;

	
	public void setTeamStrategy(Strategy strategy) {
        this.team.setStrategy(strategy);
    }

    public void setPlayerPosition(Player player, Position position) {
        this.team.getPlayers().forEach(currentPlayer -> {
            if(currentPlayer == player) {
            	currentPlayer.setPosition(position);
            }
        });
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
    
    

}
