package com.ikubinfo.reservation.model;

public class ShopService {
	private String type;
	private Double price;
	private String description;

	public ShopService(String type, Double price,String description) {
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
