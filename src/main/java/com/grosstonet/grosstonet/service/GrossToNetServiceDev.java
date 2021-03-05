package com.grosstonet.grosstonet.service;

import com.grosstonet.grosstonet.request.GrossToNetRequest;
import com.grosstonet.grosstonet.response.GrossToNetMeanResponseDev;
import com.grosstonet.grosstonet.response.GrossToNetRequestAndResponseDev;
import com.grosstonet.grosstonet.response.GrossToNetResponseDev;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Profile("dev")
public class GrossToNetServiceDev implements GrossToNetInterface {

    private final List<GrossToNetRequestAndResponseDev> grossToNetRequestAndResponses;

    public GrossToNetServiceDev() {
        this.grossToNetRequestAndResponses = new ArrayList<>();
    }

    @Override
    public GrossToNetResponseDev convertGrossToNet(GrossToNetRequest grossToNetRequest) {
        GrossToNetResponseDev grossToNetResponse = new GrossToNetResponseDev(0.91 * grossToNetRequest.getAmount());
        grossToNetRequestAndResponses.add(new GrossToNetRequestAndResponseDev(grossToNetRequest, grossToNetResponse));
        return grossToNetResponse;
    }

    public List<Object> getGrossToNetRequestAndResponses() {
        return  Collections.singletonList(grossToNetRequestAndResponses);
    }

    @Override
    public GrossToNetMeanResponseDev getNetMean() {
        double sumOfNet = this.grossToNetRequestAndResponses.stream().mapToDouble(obj -> obj.getGrossToNetResponse().getNetAmount()).sum();
        return new GrossToNetMeanResponseDev(sumOfNet / this.grossToNetRequestAndResponses.size());
    }

}
