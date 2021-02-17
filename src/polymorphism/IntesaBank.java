package polymorphism;

public class IntesaBank extends Bank {

	public Double getCredit(Integer money) {
		return 0.05*money;
	}
}
