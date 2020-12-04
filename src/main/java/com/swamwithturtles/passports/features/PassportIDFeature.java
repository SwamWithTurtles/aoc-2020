package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportIDFeature implements PassportFeature {
    private String passportId;

    public PassportIDFeature(String component) {
        this.passportId = component;
    }

    @Override
    public String getFeatureName() {
        return "PASSPORT_ID";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        Pattern p = Pattern.compile("^(\\d{9})$");
        Matcher m = p.matcher(passportId);

        return m.matches();

    }
}
