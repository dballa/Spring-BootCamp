package polymorphism;

public class UbiCsaBank extends Bank {

	public Double getCredit(Integer money) {
		return 0.06*money;
	}
}
