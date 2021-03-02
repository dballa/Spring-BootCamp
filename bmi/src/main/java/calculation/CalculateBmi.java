package calculation;

import org.springframework.web.bind.annotation.RequestBody;

import services.Request;

public class CalculateBmi {
	
	Request request;
	
	public CalculateBmi(Request request) {
		this.request=request;
	}
	
	public double getBMI(@RequestBody Request request) {
		double bmiValue = (double)(request.getWeight())/(request.getHeight()^2);
		return bmiValue;
	}
}
