package academy.abstraction;

public interface Player {

	public abstract  void play();
	
	public abstract void stop();
	
	public default void quit() {
		System.out.println("The player quited the game");
	}
}
