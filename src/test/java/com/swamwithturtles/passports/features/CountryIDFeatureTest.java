package com.swamwithturtles.passports.features;

import com.swamwithturtles.passports.PassportFeature;
import com.swamwithturtles.passports.ValidationType;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class CountryIDFeatureTest {

    @Test
    public void canConstructCountryID() {
        CountryIDFeature feature = new CountryIDFeature("countryId");

        assertThat(feature).isNotNull();
    }

    @Test
    public void countryIDIsAlwaysValid() {
        CountryIDFeature feature = new CountryIDFeature("countryId");

        assertThat(feature.isValid(ValidationType.PRESENCE)).isTrue();
        assertThat(feature.isValid(ValidationType.SEMANTIC)).isTrue();
    }

    @Test
    public void countryIdFeatureNameIsCorrect() {
        CountryIDFeature feature = new CountryIDFeature("countryId");

        assertThat(feature.getFeatureName()).isEqualTo("COUNTRY_ID");
    }
}
