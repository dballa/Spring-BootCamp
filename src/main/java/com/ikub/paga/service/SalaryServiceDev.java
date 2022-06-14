package com.ikub.paga.service;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
@Profile("dev")
@Component
public class SalaryServiceDev implements SalaryService{
    private final double COEFFICIENT = 0.9;

    public SalaryResponse getNeto(SalaryRequest request){
        SalaryResponse response = new SalaryResponse();
        double netoSalary = request.getSalaryBruto()* COEFFICIENT;
        response.setSalaryNeto(netoSalary);
        RequestResponsesDev.getInstance().putRequestResponses(request,response);
        return response;
    }

    public HashMap<SalaryRequest, SalaryResponse> getRequests(){
        HashMap<SalaryRequest, SalaryResponse> allRequests
                = RequestResponsesDev.getInstance().getRequestResponses();

        return allRequests;
    }

    private double average(ArrayList<Double> list){
        Double sum = 0.0;
        int length = list.size();
        for (Double i : list){
            sum+=i;
        }
        return sum/length;
    }
    public double averageNeto (){
        HashMap<SalaryRequest, SalaryResponse> allRequests
                = RequestResponsesDev.getInstance().getRequestResponses();
        ArrayList<Double> netos = new ArrayList<>();
        for (SalaryRequest name: allRequests.keySet()){
            netos.add(allRequests.get(name).getSalaryNeto());
        }
        return average(netos);
    }

}
