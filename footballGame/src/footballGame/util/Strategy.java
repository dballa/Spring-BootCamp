package footballGame.util;

public enum Strategy {

THREEFIVETWO(1,"Three-Five-Two"),
FOURFOURTWO(2,"Four-Four-Two"),
THREEFIVEONE(3,"Three-Five-One");
	
	private String name;
	private int id;
	
	Strategy(int id,String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
