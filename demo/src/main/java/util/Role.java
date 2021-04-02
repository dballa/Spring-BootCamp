package util;

import lombok.ToString;

@ToString
public enum Role {
	
	STUDENT(1,"Student"), PROFESSOR(2,"Professor"), COORDINATOR(3,"Coordinator"), ADMINISTRATOR(4,"Administrator");
	
	private String name;
	private int id;
	
	Role(int id, String name) {
		
		this.id = id;
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
}
