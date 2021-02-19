package footballGame.util;

public enum Position {
	
GOALKEEPER(1,"Goalkeeper"),
LEFT_DEFENSE(2,"Left Defense"),
CENTER_DEFENSE(3,"Center Defense"),
RIGHT_DEFENSE(4,"Right Defense"),
LEFT_MIDDLE(5,"Left Middle Player"),
CENTER_MIDDLE(6,"Center Middle Player"),
RIGHT_MIDDLE(7,"Right Middle Player"),
LEFT_ATTACK(8,"Left Attack"),
CENTER_ATTACK(9,"Center Attack"),
RIGHT_ATTACK(10,"Right Attack");
	
	private String name;
	private int id;
	
	Position(int id,String name) {
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
