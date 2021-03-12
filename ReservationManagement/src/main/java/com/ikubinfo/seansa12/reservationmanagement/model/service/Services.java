package com.ikubinfo.seansa12.reservationmanagement.model.service;

public class Services {
	
	private String name;
	private String code;
	private String description;

	public Services(String name, String description) {
		super();
		this.name = name;
		this.code = name+"Service";
		this.description = description;
	}

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

}
