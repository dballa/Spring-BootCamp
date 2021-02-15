package academy.lockable_door;

public class LockableDoor {

	private boolean open;
	
	private boolean locked;

	LockableDoor() {
		this.open = false;
		this.locked = false;
	}

	public void close() {
		System.out.println("Closing...");
		this.open = false;
	}

	public void unlock() {
		System.out.println("Unlocking...");
		this.locked = false;
	}

	public void attemptOpen() {
		System.out.println("Attempt to open the door...");
		if(!locked) {
			this.open = true;
			System.out.println("Open attempt was successful ...");
		} else {
			System.out.println("Open attempt was unsuccessful ...");
		}
	}
	
	public void attemptLock() {
		System.out.println("Attempt to lock the door...");
		if(!open) {
			this.locked = true; 
			System.out.println("Lock attempt was successful ...");
		} else {
			System.out.println("Lock attempt was unsuccessful ...");
		}
	}

	public String toString() {
		return "LockableDoor(" + (open ? "open" : "closed") + ":" + (locked ? "locked" : "unlocked") + ")";
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	
}
