package com.swamwithturtles.passports;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PassportDetails {

    private static final List<String> MANDATORY_KEYS = Arrays.asList(
            "BIRTH_YEAR",
            "EXPIRATION_YEAR",
            "EYE_COLOUR",
            "HAIR_COLOUR",
            "HEIGHT",
            "ISSUE_YEAR",
            "PASSPORT_ID"
    );

    private List<PassportFeature> details;

    public PassportDetails(List<PassportFeature> details) {
        this.details = details;
    }

    public static PassportDetails parse(String s) {
        String[] bits = s.split("\\s");
        List<PassportFeature> details = Arrays.stream(bits)
                .map(PassportFeatureFactory::fromString)
                .collect(Collectors.toList());
        return new PassportDetails(details);
    }

    public boolean isValid(ValidationType validationType) {
        return details.stream()
                .filter(feature -> feature.isValid(validationType))
                .map(PassportFeature::getFeatureName)
                .collect(Collectors.toSet())
                .containsAll(MANDATORY_KEYS);
    }
}
