package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.regex.Pattern;

public class HairColourFeature implements PassportFeature {
    private String hairColour;

    public HairColourFeature(String component) {
        this.hairColour = component;
    }

    @Override
    public String getFeatureName() {
        return "HAIR_COLOUR";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        Pattern p = Pattern.compile("^#[0-9a-f]{6}$");
        return p.matcher(hairColour).matches();
    }
}
