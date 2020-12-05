package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.regex.Pattern;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class HairColourFeatureTest {

    @Test
    public void canConstructHairColour() {
        HairColourFeature feature = new HairColourFeature("#ffffff");

        assertThat(feature).isNotNull();
    }

    @Test
    public void canConstructHairColourWithInvalidColour() {
        HairColourFeature feature = new HairColourFeature("BAD");

        assertThat(feature).isNotNull();
    }

    @Test
    public void hasCorrectFeatureName() {
        HairColourFeature feature = new HairColourFeature("BAD");

        assertThat(feature.getFeatureName()).isEqualTo("HAIR_COLOUR");
    }

    @Test
    public void isValidGivenPresenceValidationType() {
        HairColourFeature feature = new HairColourFeature("#ffffff");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidGivenPresenceValidationTypeEvenWithInvalidColour() {
        HairColourFeature feature = new HairColourFeature("#BAD");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidGivenSemanticValidationType() {
        HairColourFeature feature = new HairColourFeature("#ffffff");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void isValidGivenSemanticValidationTypeWithNonColourCode() {
        HairColourFeature feature = new HairColourFeature("BAD");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isValidGivenSemanticValidationTypeWithNonHexadecimalColourCode() {
        HairColourFeature feature = new HairColourFeature("#0088gg");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

    @Test
    public void isValidGivenSemanticValidationTypeWithBadLengthColourCode() {
        HairColourFeature feature = new HairColourFeature("#aaa");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

//    private String hairColour;
//
//    public HairColourFeature(String component) {
//        this.hairColour = component;
//    }
//
//    @Override
//    public String getFeatureName() {
//        return "HAIR_COLOUR";
//    }
//
//    @Override
//    public Boolean isValid(ValidationType validationType) {
//        if(validationType == ValidationType.PRESENCE) {
//            return true;
//        }
//
//        Pattern p = Pattern.compile("^#[0-9a-f]{6}$");
//        return p.matcher(hairColour).matches();
//    }
}
