package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public class IssueYearFeature implements PassportFeature {
    private Integer year;

    public IssueYearFeature(String component) {
        this.year = DateTimeUtils.parseFourDigitYear(component).orElse(null);
    }

    @Override
    public String getFeatureName() {
        return "ISSUE_YEAR";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        return year != null && year >= 2010 && year <= 2020;
    }
}
