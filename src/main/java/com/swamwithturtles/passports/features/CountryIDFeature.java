package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public class CountryIDFeature implements PassportFeature {
    private String countryId;

    public CountryIDFeature(String component) {
        this.countryId = component;
    }

    @Override
    public String getFeatureName() {
        return "COUNTRY_ID";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        return true;
    }
}
