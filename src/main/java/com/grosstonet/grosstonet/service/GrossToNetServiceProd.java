package com.grosstonet.grosstonet.service;

import com.grosstonet.grosstonet.request.GrossToNetRequest;
import com.grosstonet.grosstonet.response.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Profile("prod")
public class GrossToNetServiceProd implements GrossToNetInterface{

    private final List<GrossToNetRequestAndResponseProd> grossToNetRequestAndResponses;

    public GrossToNetServiceProd() {
        this.grossToNetRequestAndResponses = new ArrayList<>();
    }

    @Override
    public GrossToNetResponseProd convertGrossToNet(GrossToNetRequest grossToNetRequest) {
        double grossAmount = grossToNetRequest.getAmount();
        double socialInsurance = generateSocialInsurance(grossToNetRequest);
        double socialInsuranceEmployer = generateSocialInsuranceEmployer(grossToNetRequest);
        double socialContribution = generateSocialContribution(grossToNetRequest);
        double healthInsurance = generateHealthInsurance(grossToNetRequest);
        double healthInsuranceEmployer = generateHealthInsuranceEmployer(grossToNetRequest);
        double costOfEmployment = grossAmount + socialInsuranceEmployer + healthInsuranceEmployer;
        double pit = generatePit(grossToNetRequest);
        double netAmount = grossAmount - healthInsurance - socialInsurance - pit;
        GrossToNetResponseProd grossToNetResponse = new GrossToNetResponseProd(grossAmount, socialContribution, socialInsurance, healthInsurance, socialInsuranceEmployer, healthInsuranceEmployer, pit, costOfEmployment, netAmount);
        GrossToNetRequestAndResponseProd grossToNetRequestAndResponseProd = new GrossToNetRequestAndResponseProd(grossToNetRequest, grossToNetResponse);
        grossToNetRequestAndResponses.add(grossToNetRequestAndResponseProd);
        return grossToNetResponse;
    }

    @Override
    public List<Object> getGrossToNetRequestAndResponses() {
        return Collections.singletonList(this.grossToNetRequestAndResponses);
    }

    @Override
    public GrossToNetMeanResponseProd getNetMean() {
        double sumOfNet = this.grossToNetRequestAndResponses.stream().mapToDouble(obj -> obj.getGrossToNetResponse().getNetAmount()).sum();
        return new GrossToNetMeanResponseProd(sumOfNet / this.grossToNetRequestAndResponses.size());
    }


    private double generatePit(GrossToNetRequest grossToNetRequest) {
        double grossAmount = grossToNetRequest.getAmount();
        if(grossAmount < 30000) {
            return 0;
        } else if (grossAmount < 150000){
            return (grossAmount - 30000) * 0.13;
        } else {
            return 15600 + (grossAmount - 150000) * 0.23;
        }
    }

    private double generateSocialInsurance(GrossToNetRequest grossToNetRequest) {
        return grossToNetRequest.getAmount() * 0.095;
    }

    private double generateSocialInsuranceEmployer(GrossToNetRequest grossToNetRequest) {
        return grossToNetRequest.getAmount() * 0.15;
    }

    private double generateSocialContribution(GrossToNetRequest grossToNetRequest) {
        return grossToNetRequest.getAmount();
    }

    private double generateHealthInsurance(GrossToNetRequest grossToNetRequest) {
        return 0.017 * grossToNetRequest.getAmount();
    }

    private double generateHealthInsuranceEmployer(GrossToNetRequest grossToNetRequest) {
        return 0.017 * grossToNetRequest.getAmount();
    }

}
