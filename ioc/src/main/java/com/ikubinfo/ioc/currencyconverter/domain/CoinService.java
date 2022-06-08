package com.ikubinfo.ioc.currencyconverter.domain;

import org.springframework.stereotype.Service;

@Service
public interface CoinService {

    public String printCoin(String s);
}
