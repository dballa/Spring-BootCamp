package com.ikubinfo.ioc.bmiconverter.domain.bmi.response;

import com.ikubinfo.ioc.bmiconverter.domain.Bmi;
public class BmiRespnse {

	private double bmi;
	private Bmi description;

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public Bmi getDescription() {
		return description;
	}

	public void setDescription(Bmi description) {
		this.description = description;
	}

}
