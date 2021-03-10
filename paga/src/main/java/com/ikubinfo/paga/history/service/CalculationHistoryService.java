package com.ikubinfo.paga.history.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CalculationHistoryService {

	private List<CalculationHistoryModel> history;

	public CalculationHistoryService() {
		super();
		history = new ArrayList<>();
	}

	public void addToHistory(Double request, Double response) {

		history.add(new CalculationHistoryModel(request, response));

	}

	public List<CalculationHistoryModel> getHistory() {
		return history;
	}

}
