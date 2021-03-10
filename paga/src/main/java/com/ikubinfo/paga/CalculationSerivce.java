package com.ikubinfo.paga;

import org.springframework.stereotype.Service;

import com.ikubinfo.paga.history.aop.CalculationHistory;
@Service
public class CalculationSerivce {

	@CalculationHistory
	public Double calculateNeto(Double request) {
		return request * 0.91;

	}
}
