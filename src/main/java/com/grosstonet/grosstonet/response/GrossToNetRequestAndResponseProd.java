package com.grosstonet.grosstonet.response;

import com.grosstonet.grosstonet.request.GrossToNetRequest;

public class GrossToNetRequestAndResponseProd {

    private GrossToNetRequest grossToNetRequest;
    private GrossToNetResponseProd grossToNetResponse;

    public GrossToNetRequestAndResponseProd(GrossToNetRequest grossToNetRequest, GrossToNetResponseProd grossToNetResponse) {
        this.grossToNetRequest = grossToNetRequest;
        this.grossToNetResponse = grossToNetResponse;
    }

    public GrossToNetRequest getGrossToNetRequest() {
        return grossToNetRequest;
    }

    public void setGrossToNetRequest(GrossToNetRequest grossToNetRequest) {
        this.grossToNetRequest = grossToNetRequest;
    }

    public GrossToNetResponseProd getGrossToNetResponse() {
        return grossToNetResponse;
    }

    public void setGrossToNetResponse(GrossToNetResponseProd grossToNetResponse) {
        this.grossToNetResponse = grossToNetResponse;
    }
}
