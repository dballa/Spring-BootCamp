package com.bmi.app.services;

import org.springframework.stereotype.Component;

@Component
public class BmiRequest {
	private int height;
	private int weight;

	@Override
	public String toString() {
		return "Request [height=" + height + ", weight=" + weight + "]";
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
