package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class ExpirationYearFeatureTest {

    @Test
    public void canConstructExpirationYearFeature() {
        ExpirationYearFeature feature = new ExpirationYearFeature("2012");

        assertThat(feature).isNotNull();
    }

    @Test
    public void canConstructExpirationYearEvenIfInputIsInvalid() {
        ExpirationYearFeature feature = new ExpirationYearFeature("XMAS");

        assertThat(feature).isNotNull();
    }

    @Test
    public void featureNameIsPresentedCorrectly() {
        ExpirationYearFeature feature = new ExpirationYearFeature("2012");

        assertThat(feature.getFeatureName()).isEqualTo("EXPIRATION_YEAR");
    }

    @Test
    public void isValidWithPresenceValidationType() {
        ExpirationYearFeature feature = new ExpirationYearFeature("2012");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithPresenceValidationWithoutValidYear() {
        ExpirationYearFeature feature = new ExpirationYearFeature("XMAS");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithPresenceValidationWitIncorrectYear() {
        ExpirationYearFeature feature = new ExpirationYearFeature("1234");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithSemanticValidationType() {
        ExpirationYearFeature feature = new ExpirationYearFeature("2020");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void isInvalidWithSemanticValidationWithoutValidYear() {
        ExpirationYearFeature feature = new ExpirationYearFeature("XMAS");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isInvalidWithSemanticValidationWithEarlyYear() {
        ExpirationYearFeature feature = new ExpirationYearFeature("2012");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isInvalidWithSemanticValidationWithLateYear() {
        ExpirationYearFeature feature = new ExpirationYearFeature("4000");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }
}
