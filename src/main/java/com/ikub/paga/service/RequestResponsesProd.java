package com.ikub.paga.service;

import com.ikub.paga.request.SalaryRequest;
import com.ikub.paga.response.SalaryResponseProd;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
@Profile("prod")

public class RequestResponsesProd {
    private HashMap<SalaryRequest, SalaryResponseProd> requestResponses;
    private static RequestResponsesProd instance;
    private RequestResponsesProd(){
        requestResponses = new HashMap<>();
    }

    public static RequestResponsesProd getInstance(){
        if (instance==null){
            instance = new RequestResponsesProd();
        }
        return instance;
    }
    public HashMap<SalaryRequest, SalaryResponseProd> getRequestResponses() {
        return requestResponses;
    }

    public void putRequestResponses(SalaryRequest request, SalaryResponseProd response) {
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
