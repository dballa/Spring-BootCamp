package com.ikubinfo.paga.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.paga.CalculationSerivce;
import com.ikubinfo.paga.history.service.CalculationHistoryModel;
import com.ikubinfo.paga.history.service.CalculationHistoryService;

@RestController
@RequestMapping("/calculate")
public class CalculationResource {

	private CalculationSerivce calculationService;
	private CalculationHistoryService historyService;

	public CalculationResource(CalculationSerivce calculationService, CalculationHistoryService historyService) {
		super();
		this.calculationService = calculationService;
		this.historyService = historyService;
	}

	@PostMapping
	public Double calculateNet(@RequestBody CalculationRequest request) {
		return calculationService.calculateNeto(request.getValue());
	}

	@GetMapping
	public List<CalculationHistoryModel> getHistory() {
		return historyService.getHistory();
	}
}
