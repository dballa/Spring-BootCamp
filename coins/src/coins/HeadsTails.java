package coins;

public enum HeadsTails {

	HEADS(2,"Heads"), TAILS(3,"Tails");
	
	private String name;
	private int id;
	
	HeadsTails(int id,String name) {
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