package com.swamwithturtles.common;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeUtils {

    public static Optional<Integer> parseFourDigitYear(String s) {
        Pattern p = Pattern.compile("^(\\d{4})$");
        Matcher m = p.matcher(s);
        if(m.matches()) {
            return Optional.of(Integer.parseInt(m.group(1)));
        }

        return Optional.empty();
    }
}
