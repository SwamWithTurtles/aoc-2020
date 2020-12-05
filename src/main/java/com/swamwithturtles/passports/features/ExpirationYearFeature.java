package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public class ExpirationYearFeature extends YearFeature {

    public ExpirationYearFeature(String component) {
        super(component);
        this.minYear = 2020;
        this.maxYear = 2030;
    }

    @Override
    public String getFeatureName() {
        return "EXPIRATION_YEAR";
    }

}
