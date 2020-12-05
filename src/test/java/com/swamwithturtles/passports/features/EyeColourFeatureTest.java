package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class EyeColourFeatureTest {

    @Test
    public void canConstructEyeColour() {
        EyeColourFeature feature = new EyeColourFeature("hzl");

        assertThat(feature).isNotNull();
    }

    @Test
    public void canConstructEyeColourWithInvalidEyeColour() {
        EyeColourFeature feature = new EyeColourFeature("incorrect");

        assertThat(feature).isNotNull();
    }

    @Test
    public void featureNameReturnedCorrectly() {
        EyeColourFeature feature = new EyeColourFeature("hzl");

        assertThat(feature.getFeatureName()).isEqualTo("EYE_COLOUR");
    }

    @Test
    public void isValidWithPresenceType() {
        EyeColourFeature feature = new EyeColourFeature("hzl");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithPresenceTypeEvenWithDisallowedEyeColour() {
        EyeColourFeature feature = new EyeColourFeature("disallowed");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
    }

    @Test
    public void isValidWithSemanticTypeWithAllowedEyeColour() {
        EyeColourFeature feature = new EyeColourFeature("hzl");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void isValidWithSemanticTypeWithDisllowedEyeColour() {
        EyeColourFeature feature = new EyeColourFeature("disallowed");

        assertThat(feature.isValid(ValidationType.SEMANTIC)).isFalse();
    }

}
