package com.grosstonet.grosstonet.service;

import com.grosstonet.grosstonet.request.GrossToNetRequest;
import com.grosstonet.grosstonet.response.GrossToNetRequestAndResponseDev;

import java.util.List;

public interface GrossToNetInterface {

    Object convertGrossToNet(GrossToNetRequest grossToNetRequest);

    List<Object> getGrossToNetRequestAndResponses();

    Object getNetMean();

}