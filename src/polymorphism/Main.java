package polymorphism;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Bank intesa = new IntesaBank();
		Bank ubi = new UbiBank();
		Bank ubiCsa = new UbiCsaBank();
		
		Integer money = new Integer(300);
		System.out.println(bank.getCredit(money));
		System.out.println(intesa.getCredit(money));
		System.out.println(ubi.getCredit(money));
		System.out.println(ubiCsa.getCredit(money));

	}
}
