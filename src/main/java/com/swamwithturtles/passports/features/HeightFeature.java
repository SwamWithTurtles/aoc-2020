package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeightFeature implements PassportFeature {
    private HeightUnit heightUnit;
    private Integer measure;

    public HeightFeature(String component) {
        Pattern p = Pattern.compile("^(\\d+)(\\w+)$");
        Matcher m = p.matcher(component);
        if(m.matches()) {
            heightUnit = HeightUnit.fromShortHand(m.group(2));
            measure = Integer.parseInt(m.group(1));
        }
    }

    @Override
    public String getFeatureName() {
        return "HEIGHT";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        if(heightUnit == null || measure == null) {
            return false;
        }

        if(heightUnit == HeightUnit.INCHES) {
            return measure >= 59 && measure <= 76;
        }

        if(heightUnit == HeightUnit.CENTIMETERS) {
            return measure >= 150 && measure <= 193;
        }

        throw new RuntimeException("Wat?");
    }
}
