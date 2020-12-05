package com.swamwithturtles.passports;

import com.swamwithturtles.passports.features.BirthYearFeature;
import com.swamwithturtles.passports.features.CountryIDFeature;
import com.swamwithturtles.passports.features.ExpirationYearFeature;
import com.swamwithturtles.passports.features.EyeColourFeature;
import com.swamwithturtles.passports.features.HairColourFeature;
import com.swamwithturtles.passports.features.HeightFeature;
import com.swamwithturtles.passports.features.IssueYearFeature;
import com.swamwithturtles.passports.features.PassportIDFeature;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class PassportFeatureFactoryTest {
//
//             case "byr":
//                     return new BirthYearFeature(components[1]);
//            case "iyr":
//                    return new IssueYearFeature(components[1]);
//            case "eyr":
//                    return new ExpirationYearFeature(components[1]);
//            case "hgt":
//                    return new HeightFeature(components[1]);
//            case "hcl":
//                    return new HairColourFeature(components[1]);
//            case "ecl":
//                    return new EyeColourFeature(components[1]);
//            case "pid":
//                    return new PassportIDFeature(components[1]);
//            case "cid":
//                    return new CountryIDFeature(components[1]);
//
    @Test
    public void canConstructBirthYearFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("byr:asd");

        assertThat(feature).isInstanceOf(BirthYearFeature.class);
    }

    @Test
    public void canConstructIssueYearFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("iyr:asd");

        assertThat(feature).isInstanceOf(IssueYearFeature.class);
    }

    @Test
    public void canConstructExpirationYearFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("eyr:asd");

        assertThat(feature).isInstanceOf(ExpirationYearFeature.class);
    }

    @Test
    public void canConstructHeightFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("hgt:asd");

        assertThat(feature).isInstanceOf(HeightFeature.class);
    }

    @Test
    public void canConstructHairColourFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("hcl:asd");

        assertThat(feature).isInstanceOf(HairColourFeature.class);
    }

    @Test
    public void canConstructEyeColourFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("ecl:asd");

        assertThat(feature).isInstanceOf(EyeColourFeature.class);
    }

    @Test
    public void canConstructPassportIdFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("pid:asd");

        assertThat(feature).isInstanceOf(PassportIDFeature.class);
    }

    @Test
    public void canConstructCountryIdFeature() {
        PassportFeature feature = PassportFeatureFactory.fromString("cid:asd");

        assertThat(feature).isInstanceOf(CountryIDFeature.class);
    }

    @Test
    public void doesNotConstructUnrecognisedFeature() {
        PassportFeature feature = null;
        try {
            feature = PassportFeatureFactory.fromString("xxx:asd");
        } catch (RuntimeException ex) {}

        assertThat(feature).isNull();
    }
}
