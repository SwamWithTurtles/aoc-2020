package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class PassportIDFeatureTest {

    @Test
    public void passportIdFeatureCanBeConstructedWithValidId() {
        PassportIDFeature feature = new PassportIDFeature("000111222");

        assertThat(feature).isNotNull();
    }

    @Test
    public void passportIdFeatureCanBeConstructedWithInvalidId() {
        PassportIDFeature feature = new PassportIDFeature("XYZ");

        assertThat(feature).isNotNull();
    }

    @Test
    public void passportIdFeatureIsValidWithExistenceChecks() {
        PassportIDFeature feature = new PassportIDFeature("000111222");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void passportIdFeatureIsValidWithExistenceChecksAndInvalidId() {
        PassportIDFeature feature = new PassportIDFeature("XYZ");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void passportIdFeatureIsValidWithSemanticChecks() {
        PassportIDFeature feature = new PassportIDFeature("000111222");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void passportIdFeatureIsInalidWithSemanticChecksAndNonDigitCharacters() {
        PassportIDFeature feature = new PassportIDFeature("000AAA222");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void passportIdFeatureIsInalidWithSemanticChecksAndWrongNumberOfDigitCharacters() {
        PassportIDFeature feature = new PassportIDFeature("012");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void passportIdFeatureHasCorrectFeatureName() {
        PassportIDFeature feature = new PassportIDFeature("012");

        assertThat(feature.getFeatureName()).isEqualTo("PASSPORT_ID");
    }
}
