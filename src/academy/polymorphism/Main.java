package academy.polymorphism;

public class Main {

	public static void main(String[] args) {
		
		//RUNTIME
//		Animal animal = new Animal();		// --> Animal
		Animal dog = new Dog();				// --> Dog
		Animal pig = new Pig();				// --> Pig
		
//		animal.eat();		// --> animal .....
		dog.eat();			
		pig.eat();
		
		//COMPILE TIME
		System.out.println(add(1, 2));
		System.out.println(add(1, 2, 3));
	}
	
	
	public static int  add(int number1, int number2) {
		return number1 + number2;
	}
	
	public static int add(int number1, int number2, int number3) {
		return number1 + number2 + number3;
	}
}
