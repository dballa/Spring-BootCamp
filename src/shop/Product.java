package shop;


import java.math.BigInteger;

public class Product  {

    private String name;

    private String code;

    private String description;

    private BigInteger price;

    private BarberShop barberShop;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getPrice() {
		return price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}

	public BarberShop getBarberShop() {
		return barberShop;
	}

	public void setBarberShop(BarberShop barberShop) {
		this.barberShop = barberShop;
	}

    
}
