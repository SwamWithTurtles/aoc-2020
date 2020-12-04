package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public class ExpirationYearFeature implements PassportFeature {
    private Integer year;

    public ExpirationYearFeature(String component) {
        this.year = DateTimeUtils.parseFourDigitYear(component).orElse(null);
    }

    @Override
    public String getFeatureName() {
        return "EXPIRATION_YEAR";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        return year != null && year >= 2020 && year <= 2030;
    }
}
