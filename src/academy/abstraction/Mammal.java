package academy.abstraction;

public abstract class Mammal {

	protected String race;
	
	public abstract void eat();
	
	public void run() {
		System.out.println("All mamals runs with 4 legs.");
	}
}
