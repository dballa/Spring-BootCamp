package com.ikub.paga.service;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponse;

import java.util.HashMap;

public interface SalaryService {
    public SalaryResponse getNeto(SalaryRequest request);
    HashMap<SalaryRequest, SalaryResponse> getRequests();
    public double averageNeto ();
}
