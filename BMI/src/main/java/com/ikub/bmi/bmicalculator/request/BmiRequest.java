package com.ikub.bmi.bmicalculator.request;

import org.springframework.stereotype.Component;

@Component
public class BmiRequest {

	private float height;
	private float weight;
	
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "BmiRequest [height=" + height + ", weight=" + weight + "]";
	}
	
	
	
	
}
