package polymorphism;

public class UbiBank extends Bank {

	public Double getCredit(Integer money) {
		return 0.02*money;
	}
	
}
