package com.ikubinfo.reservation.model;
import java.time.LocalDateTime;

public class Reservation {
	
	private String username;
	private String ShopServiceType;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public Reservation(String shopServiceType,String username,LocalDateTime startDate,LocalDateTime endDate){
		this.ShopServiceType = shopServiceType;
		this.username = username;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getShopServiceType() {
		return ShopServiceType;
	}
	public void setShopServiceType(String shopServiceType) {
		ShopServiceType = shopServiceType;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	
}
