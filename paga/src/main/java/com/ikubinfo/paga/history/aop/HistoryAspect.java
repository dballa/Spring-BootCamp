package com.ikubinfo.paga.history.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ikubinfo.paga.history.service.CalculationHistoryService;

@Aspect
@Component
public class HistoryAspect {

	@Autowired
	private CalculationHistoryService calculationHistoryService;
	
	

	public HistoryAspect(CalculationHistoryService calculationHistoryService) {
		super();
		this.calculationHistoryService = calculationHistoryService;
	}



	@Around("@annotation(com.ikubinfo.paga.history.aop.CalculationHistory)")
	public Object saveHistory(ProceedingJoinPoint joinPoint) throws Throwable {

		Object request = joinPoint.getArgs()[0];
		Object response = joinPoint.proceed();
		System.out.println(String.format("adding to history request %s and response %s ", request, response));
		calculationHistoryService.addToHistory((Double) request, (Double) response);

		return response;
	}

}