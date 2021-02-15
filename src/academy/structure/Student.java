package academy.structure;

public class Student {

	private String name;

	private int age;

	private String color;

	private String sex;

	public Student(String name) {
		super();
		this.name = name;
	}

	public void eat(int quantity) {
		System.out.println(name + " can eat " + quantity);
	}

	public void drink(int quantity) {
		System.out.println(name + " can eat" + quantity);
	}

	public void run(int length) {
		System.out.println(name + " can run " + length);
	}

	public static void main(String[] args) {
		Student john = new Student("john");
		john.eat(4);
		john.drink(3);
		john.run(10);

		Student sophia = new Student("sophia");
		sophia.eat(1);
		sophia.drink(2);
		sophia.run(3);

		Student lily = new Student("lily");
		lily.eat(2);
		lily.drink(3);
		lily.run(5);

	}
}
