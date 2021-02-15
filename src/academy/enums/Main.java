package academy.enums;

import academy.abstraction.User;

public class Main {

	public static void main(String[] args) {
		System.out.println(Role.ADMIN);
		System.out.println(Role.ADMIN.getRole());
		System.out.println(Role.ADMIN.getDescription());
		System.out.println(Color.BLACK);
		User klevis = new User("klevis", "User with privileges");
		if(klevis.getRole().equals(Role.ADMIN.getRole())) {
			System.out.println("Congrats");
		} else {
			System.out.println("eh");
		}
	}
}
