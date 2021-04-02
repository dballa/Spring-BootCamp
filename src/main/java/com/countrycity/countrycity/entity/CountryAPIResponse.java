package com.countrycity.countrycity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class CountryAPIResponse implements Serializable {

    private String flag;
    private String capital;
    private String region;
    private String subregion;
    private String numericCode;

}

