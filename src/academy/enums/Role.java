package academy.enums;

public enum Role {

	CLIENT("The simple user", "Has access to login to application and do ........", 5),
	ADMIN("User with privileges", "Has access to delete everything that he wants", 6);

	private String role;

	private String description;

	private Integer id;
	
	private Role(String role, String description, Integer id) {
		this.role = role;
		this.description = description;
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public String getDescription() {
		return description;
	}
	
	public Integer getId() {
		return id;
	}
}
