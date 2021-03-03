package com.ikubinfo.ioc.bmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmi")
public class BmiResource {
	
	@Autowired
	BmiService bmiService;

	public BmiResource(BmiService bmiService) {

		this.bmiService = bmiService;
	}

	@PostMapping
	private BmiIndex calculateBmi(@RequestBody BmiRequest request) {

		double bmi = bmiService.calculateBmi(request.getHeight(), request.getWeight());
		String tranlation = bmiService.translateBmiValue(bmi);

		return new BmiIndex(bmi, tranlation);
	}

}
