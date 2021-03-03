package com.ikubinfo.ioc.bmiconverter.domain;

import java.util.stream.Stream;

public enum Bmi {
	UNDERWEIGHT("Underweight",1), NORMAL("Normal",2), WEIGHT("Weight",3), OVERWEIGHT("Overweight",4 ), OBESITY("Obesity",5);
	
	private Bmi(String description, int code) {
		this.description=description;
		this.code=code;
	}
	
	private String description;
	private int code;
	
	public static Bmi forCode(int code) {

		return Stream.of(Bmi.values()).filter(bmi -> bmi.getCode() == code).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
}
