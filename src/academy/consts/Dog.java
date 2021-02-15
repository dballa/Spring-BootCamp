package academy.consts;

import java.util.Date;

public class Dog extends Animal{

	private String type;
	
	public void run() {
		System.out.println(this.type + " runs 3 km");
		System.out.println(super.name + " runs 4 km");
//		System.out.println(super.age + " runs 5 km");
		
		Dog lesi = new Dog();
		Dog spike = new Dog("golden retriever");
	}


	public Dog(String type) {
		type = type;
		this.type = type;
	}
	
	public Dog(String type, String name) {
		this.type = type; 
		super.name = name;
	}
	
	public Dog() {
		super();
		
	}
	
	public int speep(int sasia) {
		return sasia;
	}
	
	protected void speep(Date time) {
		System.out.println("asdasdas");
	}
	
	@Override
	public void eat(int sasia) {
		System.out.println("Dog can eat " + sasia);
	}
}
