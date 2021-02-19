package coins;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
	List<Coin> coins = new ArrayList<Coin>();
	
	Coin myCoin1 = new Coin();
	myCoin1.setId(1);
	Coin myCoin2 = new Coin();
	myCoin2.setId(2);
	Coin myCoin3 = new Coin();
	myCoin3.setId(3);
	
	
	myCoin1.flip();
	myCoin1.flip();
	myCoin1.flip();
	myCoin2.flip();
	myCoin2.flip();
	myCoin3.flip();
	
	coins.add(myCoin1);
	coins.add(myCoin2);
	coins.add(myCoin3);
	
	for (Coin coin : coins) {
	System.out.println("The number of flips for coin"+coin.getId()+" is "+coin.getTotalNumberOfFlipsForThisCoin());
	}
	
	System.out.println("The number of All flips for All Coins is = "+Coin.getTotalNumberOfFlipsForAllCoins());
	
	}
  }


