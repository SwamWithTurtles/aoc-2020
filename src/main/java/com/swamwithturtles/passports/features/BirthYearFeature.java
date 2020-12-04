package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public class BirthYearFeature implements PassportFeature {
    private Integer year;

    public BirthYearFeature(String component) {
        this.year = DateTimeUtils.parseFourDigitYear(component).orElse(null);
    }

    @Override
    public String getFeatureName() {
        return "BIRTH_YEAR";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        return year != null && year >= 1920 && year <= 2002;
    }
}
