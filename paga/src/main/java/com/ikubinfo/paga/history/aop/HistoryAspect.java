package com.ikubinfo.paga.history.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HistoryAspect {

	@Autowired
	CalculationHistoryService calculationHistoryService;

	@Around("@annotation(com.ikubinfo.paga.history.aop.CalculationHistory)")
	public Object trackHistory(ProceedingJoinPoint joinPoint) throws Throwable {

		Object request = joinPoint.getArgs()[0];
		Object response = joinPoint.proceed();

		calculationHistoryService.addToHistory((Double) request, (Double) response);

		return response;
	}

}