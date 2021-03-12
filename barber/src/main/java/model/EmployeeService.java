package model;

import java.math.BigInteger;

public class EmployeeService{

	private BigInteger price;

	private int duration;

	private Employee employee;

	private ShopService shopService;

	public BigInteger getPrice() {
		return price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public void setService(ShopService shopService) {
		this.shopService = shopService;
	}

}

