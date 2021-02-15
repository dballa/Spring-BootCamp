package academy.lockable_door;

public class LockableDoorTest {

	public static void main(String[] args) {
		LockableDoor door = new LockableDoor();
	    System.out.println(door);
	    door.attemptOpen();
	    System.out.println(door);
	    door.attemptLock();
	    System.out.println(door);
	    door.close();
	    System.out.println(door);
	    door.attemptLock();
	    System.out.println(door);
	    door.attemptOpen();
	    System.out.println(door);
	    door.unlock();
	    System.out.println(door);
	}
}
