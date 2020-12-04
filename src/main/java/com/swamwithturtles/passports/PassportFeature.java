package com.swamwithturtles.passports;

public interface PassportFeature {

    String getFeatureName();

    Boolean isValid(ValidationType validationType);
}
