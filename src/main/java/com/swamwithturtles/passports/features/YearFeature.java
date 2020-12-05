package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;

public abstract class YearFeature implements PassportFeature {

    protected Integer year;

    protected Integer minYear;
    protected Integer maxYear;

    public YearFeature(String component) {
        this.year = DateTimeUtils.parseFourDigitYear(component).orElse(null);
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        return this.year != null
                && this.year >= this.minYear
                && this.year <= this.maxYear;
    }
}
