package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.Arrays;
import java.util.List;

public class EyeColourFeature implements PassportFeature {
    private String eyeColour;

    private static final List<String> ALLOWED_EYE_COLOURS = Arrays.asList(
            "amb",
            "blu",
            "brn",
            "gry",
            "grn",
            "hzl",
            "oth"
    );

    public EyeColourFeature(String component) {
        this.eyeColour = component;
    }

    @Override
    public String getFeatureName() {
        return "EYE_COLOUR";
    }

    @Override
    public Boolean isValid(ValidationType validationType) {
        if(validationType == ValidationType.PRESENCE) {
            return true;
        }

        return ALLOWED_EYE_COLOURS.contains(eyeColour);
    }
}
