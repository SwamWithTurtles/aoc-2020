package com.swamwithturtles.passports.features;

import com.swamwithturtles.common.DateTimeUtils;
import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Test;

public class IssueYearFeatureTest {

    @Test
    public void canConstructIssueYearFeature() {
        IssueYearFeature feature = new IssueYearFeature("2012");

        assertThat(feature).isNotNull();
    }

    @Test
    public void canConstructExpirationYearEvenIfInputIsInvalid() {
        IssueYearFeature feature = new IssueYearFeature("XMAS");

        assertThat(feature).isNotNull();
    }

    @Test
    public void featureNameIsPresentedCorrectly() {
        IssueYearFeature feature = new IssueYearFeature("2012");

        assertThat(feature.getFeatureName()).isEqualTo("ISSUE_YEAR");
    }

    @Test
    public void isValidWithPresenceValidationType() {
        IssueYearFeature feature = new IssueYearFeature("2012");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithPresenceValidationWithoutValidYear() {
        IssueYearFeature feature = new IssueYearFeature("XMAS");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithPresenceValidationWitIncorrectYear() {
        IssueYearFeature feature = new IssueYearFeature("1234");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithSemanticValidationType() {
        IssueYearFeature feature = new IssueYearFeature("2019");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void isInvalidWithSemanticValidationWithoutValidYear() {
        IssueYearFeature feature = new IssueYearFeature("XMAS");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isInvalidWithSemanticValidationWithEarlyYear() {
        IssueYearFeature feature = new IssueYearFeature("2009");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isInvalidWithSemanticValidationWithLateYear() {
        IssueYearFeature feature = new IssueYearFeature("4000");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }
//    private Integer year;
//
//    public IssueYearFeature(String component) {
//        this.year = DateTimeUtils.parseFourDigitYear(component).orElse(null);
//    }
//
//    @Override
//    public String getFeatureName() {
//        return "ISSUE_YEAR";
//    }
//
//    @Override
//    public Boolean isValid(ValidationType validationType) {
//        if(validationType == ValidationType.PRESENCE) {
//            return true;
//        }
//
//        return year != null && year >= 2010 && year <= 2020;
//    }
}
