package academy.abstraction;

public class User extends Mammal implements Player {

	private String name;
	
	private String role;
	
	@Override
	public void play() {
		System.out.println(name + " plays for 2 hours" );
	}

	@Override
	public void stop() {
		System.out.println(name + " stops for 1 hour" );
		
	}

	@Override
	public void eat() {
		System.out.println(name + " eats 3 meals" );
	}

	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public static void main(String[] args) {
		User test = new User("klevis", "Admin");
//		Mammal test = new User("klevis");
		test.eat();
		test.stop();
		test.play();
		test.run();
		test.quit();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
