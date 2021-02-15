package academy;

import academy.access_modifier.User;

//DIFFERENT PACKAGE
public class Main {

	public static void main(String[] args) {
		User a = new User();
		System.out.println(a.password);
//		System.out.println(a.age);
//		System.out.println(a.surname);
//		System.out.println(a.name);
	}

}
