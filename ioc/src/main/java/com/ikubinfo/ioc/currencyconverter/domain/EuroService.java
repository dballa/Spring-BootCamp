package com.ikubinfo.ioc.currencyconverter.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("euro")
public class EuroService implements CoinService{
    @Override
    public String printCoin(String s) {
        System.out.println(s+" is euro");
        return s;
    }
}
