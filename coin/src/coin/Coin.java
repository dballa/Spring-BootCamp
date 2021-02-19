package coin;

public class Coin {

	private int id;
	private int face;
	private int totalNumberOfFlipsForThisCoin =0;
	public static int totalNumberOfFlipsForAllCoins =0;

	public Coin (){
	}

	public int flip (){
	this.face = (int) (Math.random()*2);
	totalNumberOfFlipsForThisCoin++;
	totalNumberOfFlipsForAllCoins++;
	if(this.face==0) {
	return HeadTail.HEADS.getId();	
	}else {
	return HeadTail.TAILS.getId();	
	 }	
	}

	public int getTotalNumberOfFlipsForThisCoin() {
		return totalNumberOfFlipsForThisCoin;
	}

	public static int getTotalNumberOfFlipsForAllCoins() {
		return totalNumberOfFlipsForAllCoins;
	}
	
	public int getFace() {
		return face;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	     
	}
