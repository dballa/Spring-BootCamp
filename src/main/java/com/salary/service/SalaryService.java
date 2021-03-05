package com.salary.service;

import com.salary.model.SalaryRequest;
import com.salary.model.SalaryResponse;

public interface SalaryService {
	public SalaryResponse calculateNet(SalaryRequest request);
}
