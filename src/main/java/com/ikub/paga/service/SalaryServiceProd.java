package com.ikub.paga.service;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;


@Profile("prod")
@Component
public class SalaryServiceProd implements SalaryService{

    private final double  GROSS_BAND1 = 30000.0;
    private final double  GROSS_BAND2 = 150000.0;
    private final double  RATE1 = 0.13;
    private final double  RATE2 = 0.23;
    private final double  SOCIAL_SECURITY_CAP = 114670;
    private final double  SOCIAL_SECURITY_RATE = 0.095;
    private final double  HEALTH_INSURANCE_RATE = 0.017;
    private final double  RATE_BETWEEN = 120000;

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
    public SalaryResponse getNeto(SalaryRequest request) {
        SalaryResponse response = new SalaryResponse();

        if (request.getSalaryBruto()<26000){
            response.setSalaryNeto(request.getSalaryBruto());
            RequestResponsesDev.getInstance().putRequestResponses(request,response);
            return response;
        }

        double bruto = request.getSalaryBruto();
        double neto ;
        double tatimi = 0;
        double socInsurance = 0;
        double healthInsurance = 0;
        if (bruto > GROSS_BAND1){
            if (bruto<=GROSS_BAND2){
                 tatimi = RATE1*(bruto-GROSS_BAND1);
                 socInsurance = SOCIAL_SECURITY_RATE*bruto;
            } else {
                tatimi = RATE2*(bruto-GROSS_BAND2)+RATE1*(RATE_BETWEEN);
                if (bruto>SOCIAL_SECURITY_CAP){
                    socInsurance = SOCIAL_SECURITY_RATE*SOCIAL_SECURITY_CAP;
                } else {
                    socInsurance = SOCIAL_SECURITY_RATE*bruto;
                }
            }
            healthInsurance = HEALTH_INSURANCE_RATE*bruto;
        }
        neto = bruto-socInsurance-healthInsurance-tatimi;
        response.setSalaryNeto(neto);

        RequestResponsesDev.getInstance().putRequestResponses(request,response);
        return response;
    }

}
