package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class HeightFeatureTest {

    @Test
    public void canConstruct() {
        HeightFeature feature = new HeightFeature("180cm");

        assertThat(feature).isNotNull();
    }

    @Test
    public void canConstructWithInvalidHeight() {
        HeightFeature feature = new HeightFeature("190ft");

        assertThat(feature).isNotNull();
    }

    @Test
    public void hasCorrectFeatureName() {
        HeightFeature feature = new HeightFeature("180cm");

        assertThat(feature.getFeatureName()).isEqualTo("HEIGHT");
    }

    @Test
    public void isValidForPresenceValidation() {
        HeightFeature feature = new HeightFeature("180cm");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidForPresenceValidationWithInvalidHeight() {
        HeightFeature feature = new HeightFeature("BAD");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidForSemanticPresenceInCm() {
        HeightFeature feature = new HeightFeature("180cm");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void isValidForSemanticPresenceInInches() {
        HeightFeature feature = new HeightFeature("60in");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void isInvalidForSemanticPresenceWithGarbledFormat() {
        HeightFeature feature = new HeightFeature("BAD");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    public void isValidForSemanticPresenceWithUnrecognizedUnits() {
        HeightFeature feature = new HeightFeature("6ft");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isValidForSemanticPresenceWithInchesTooLow() {
        HeightFeature feature = new HeightFeature("4in");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isValidForSemanticPresenceWithInchesTooHigh() {
        HeightFeature feature = new HeightFeature("100in");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isValidForSemanticPresenceWithCmTooLow() {
        HeightFeature feature = new HeightFeature("130cm");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isValidForSemanticPresenceWithCmTooHigh() {
        HeightFeature feature = new HeightFeature("300cm");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }
}
