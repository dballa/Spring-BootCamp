package academy.access_modifier;

// SAME PACKAGE
public class UserTest {

	public static void main(String[] args) {
		User a = new User();
		System.out.println(a.password);
		System.out.println(a.age);
		System.out.println(a.surname);
//		System.out.println(a.name);
	}
}
