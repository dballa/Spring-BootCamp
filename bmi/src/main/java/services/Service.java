package services;

import org.springframework.stereotype.Component;

import calculation.CalculateBmi;

@Component
public class Service {
	CalculateBmi calculateBmi;

	public Service(CalculateBmi calculateBmi) {
		this.calculateBmi = calculateBmi;
	}

	public Response generateResponse(Request request) {
		Response response = new Response();
		double bmi = calculateBmi.getBMI(request);
		if (bmi < 18.5) {
			response.setBmiValue(bmi);
			response.setDescription("Underweight");
		} else if (bmi < 24.9) {
			response.setBmiValue(bmi);
			response.setDescription("Normal Weight");
		} else if (bmi < 29.9) {
			response.setBmiValue(bmi);
			response.setDescription("Overweight");
		} else if (bmi < 40) {
			response.setBmiValue(bmi);
			response.setDescription("Obesity");
		}
		return response;
	}
}
