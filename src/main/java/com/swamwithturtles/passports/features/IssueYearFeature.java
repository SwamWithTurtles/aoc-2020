package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public class IssueYearFeature extends YearFeature {

    public IssueYearFeature(String component) {
        super(component);
        this.minYear = 2010;
        this.maxYear = 2020;
    }

    @Override
    public String getFeatureName() {
        return "ISSUE_YEAR";
    }
}
