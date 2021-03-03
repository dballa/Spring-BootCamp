package com.ikubinfo.ioc.bmiconverter.domain;
public enum Bmi {

	UNDERWEIGHT("<18.5", 1, 12.5), NORMALWEIGHT("18.5-24.9", 2, 20.0), OVERWEIGHT("25-29.9", 3, 26.5), OBESITY(">30", 1, 31.0);

	private double bmi;

	private Bmi(String name, int code, double bmi) {
		this.name = name;
		this.code = code;
		this.bmi=bmi;
	}

	private String name;
	private int code;

	public Bmi setDescription() {

		if (bmi<18.5)
		{
			return Bmi.UNDERWEIGHT;
		}
		else if (bmi>18.5 && bmi<24.9)
		{
			return Bmi.NORMALWEIGHT;
		}
		else if(bmi>25.0 && bmi<29.9)
		{
			return Bmi.OVERWEIGHT;
		}
		else
		{
			return Bmi.OBESITY;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
