package academy.access_modifier;

public class User {

	private String name;
	
	String surname;
	
	protected int age;
	
	public String password;
	
	
	public void login() {
		String fullname = name + " " + surname;
		System.out.println(fullname);
		System.out.println(age);
		System.out.println(password);
	}
}
