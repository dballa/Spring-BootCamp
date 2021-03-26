package com.book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class BookDtoForCreate {

	private Long id;

	private String name;

	private int price;
	
	private int rate;
	
	private long publisher;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public long getPublisher() {
		return publisher;
	}

	public void setPublisher(long publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookDtoForCreate [id=" + id + ", name=" + name + ", price=" + price + ", rate=" + rate + ", publisher="
				+ publisher + "]";
	}

}
