package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Test;

public class BirthYearFeatureTest {

    @Test
    public void canConstructBirthYearFeature() {
        BirthYearFeature feature = new BirthYearFeature("2012");

        assertThat(feature).isNotNull();
    }

    @Test
    public void canConstructExpirationYearEvenIfInputIsInvalid() {
        BirthYearFeature feature = new BirthYearFeature("XMAS");

        assertThat(feature).isNotNull();
    }

    @Test
    public void featureNameIsPresentedCorrectly() {
        BirthYearFeature feature = new BirthYearFeature("2012");

        assertThat(feature.getFeatureName()).isEqualTo("BIRTH_YEAR");
    }

    @Test
    public void isValidWithPresenceValidationType() {
        BirthYearFeature feature = new BirthYearFeature("2012");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithPresenceValidationWithoutValidYear() {
        BirthYearFeature feature = new BirthYearFeature("XMAS");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithPresenceValidationWitIncorrectYear() {
        BirthYearFeature feature = new BirthYearFeature("1234");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithSemanticValidationType() {
        BirthYearFeature feature = new BirthYearFeature("1990");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void isInvalidWithSemanticValidationWithoutValidYear() {
        BirthYearFeature feature = new BirthYearFeature("XMAS");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isInvalidWithSemanticValidationWithEarlyYear() {
        BirthYearFeature feature = new BirthYearFeature("1200");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isInvalidWithSemanticValidationWithLateYear() {
        BirthYearFeature feature = new BirthYearFeature("4000");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }
//    private Integer year;
//
//    public BirthYearFeature(String component) {
//        this.year = DateTimeUtils.parseFourDigitYear(component).orElse(null);
//    }
//
//    @Override
//    public String getFeatureName() {
//        return "BIRTH_YEAR";
//    }
//
//    @Override
//    public Boolean isValid(ValidationType validationType) {
//        if(validationType == ValidationType.PRESENCE) {
//            return true;
//        }
//
//        return year != null && year >= 1920 && year <= 2002;
//    }
}
