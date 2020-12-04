package com.swamwithturtles.passports;

import com.swamwithturtles.passports.features.BirthYearFeature;
import com.swamwithturtles.passports.features.CountryIDFeature;
import com.swamwithturtles.passports.features.ExpirationYearFeature;
import com.swamwithturtles.passports.features.EyeColourFeature;
import com.swamwithturtles.passports.features.HairColourFeature;
import com.swamwithturtles.passports.features.HeightFeature;
import com.swamwithturtles.passports.features.IssueYearFeature;
import com.swamwithturtles.passports.features.PassportIDFeature;

public class PassportFeatureFactory {

    public static PassportFeature fromString(String s) {
        String[] components = s.split(":");
        switch(components[0]) {
            case "byr":
                return new BirthYearFeature(components[1]);
            case "iyr":
                return new IssueYearFeature(components[1]);
            case "eyr":
                return new ExpirationYearFeature(components[1]);
            case "hgt":
                return new HeightFeature(components[1]);
            case "hcl":
                return new HairColourFeature(components[1]);
            case "ecl":
                return new EyeColourFeature(components[1]);
            case "pid":
                return new PassportIDFeature(components[1]);
            case "cid":
                return new CountryIDFeature(components[1]);
            default:
                throw new RuntimeException();
        }
    }
}
