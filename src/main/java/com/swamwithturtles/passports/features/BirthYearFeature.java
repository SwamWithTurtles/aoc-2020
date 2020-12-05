package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public class BirthYearFeature extends YearFeature {

    public BirthYearFeature(String component) {
        super(component);
        this.minYear = 1920;
        this.maxYear = 2002;
    }

    @Override
    public String getFeatureName() {
        return "BIRTH_YEAR";
    }
}
