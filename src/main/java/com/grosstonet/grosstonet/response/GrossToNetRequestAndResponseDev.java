package com.grosstonet.grosstonet.response;

import com.grosstonet.grosstonet.request.GrossToNetRequest;

public class GrossToNetRequestAndResponseDev {

    private GrossToNetRequest grossToNetRequest;
    private GrossToNetResponseDev grossToNetResponse;

    public GrossToNetRequestAndResponseDev(GrossToNetRequest grossToNetRequest, GrossToNetResponseDev grossToNetResponse) {
        this.grossToNetRequest = grossToNetRequest;
        this.grossToNetResponse = grossToNetResponse;
    }

    public GrossToNetRequest getGrossToNetRequest() {
        return grossToNetRequest;
    }

    public void setGrossToNetRequest(GrossToNetRequest grossToNetRequest) {
        this.grossToNetRequest = grossToNetRequest;
    }

    public GrossToNetResponseDev getGrossToNetResponse() {
        return grossToNetResponse;
    }

    public void setGrossToNetResponse(GrossToNetResponseDev grossToNetResponse) {
        this.grossToNetResponse = grossToNetResponse;
    }
}
