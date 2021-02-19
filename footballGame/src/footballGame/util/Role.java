package footballGame.util;

public enum Role {

	REFEREE(1,"Referee"), COACH(2,"Coach"), PLAYER(3,"Player");
	
	private String name;
	private int id;
	
	Role(int id,String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
}
