package services;

public class Request {
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
