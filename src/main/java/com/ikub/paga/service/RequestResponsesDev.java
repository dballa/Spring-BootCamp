package com.ikub.paga.service;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponse;

import java.util.HashMap;


public class RequestResponsesDev {
    private  HashMap<SalaryRequest, SalaryResponse> requestResponses;
    private static RequestResponsesDev instance;
    private RequestResponsesDev(){
        requestResponses = new HashMap<>();
    }

    public static RequestResponsesDev getInstance(){
        if (instance==null){
            instance = new RequestResponsesDev();
        }
        return instance;
    }
    public HashMap<SalaryRequest, SalaryResponse> getRequestResponses() {
        return requestResponses;
    }

    public void putRequestResponses(SalaryRequest request, SalaryResponse response) {
       requestResponses.put(request,response);
    }

    @Override
    public String toString() {
        String str = "";
        for (SalaryRequest name: requestResponses.keySet()){
            String key = name.toString();
            String value = requestResponses.get(name).toString();
            str+=key + " " + value + " ";
        }
        return "RequestResponses{ "+str+" }";
    }
}
