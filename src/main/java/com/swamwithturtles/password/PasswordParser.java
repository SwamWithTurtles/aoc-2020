package com.swamwithturtles.password;

import com.swamwithturtles.common.datastructure.IntPair;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordParser {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(\\d+)-(\\d+) (\\w): (\\w+)$");

    public static PasswordEntry parse(IndexInterpretation indexInterpretation, String passwordLineItem) {
        Matcher matcher = PASSWORD_PATTERN.matcher(passwordLineItem);
        matcher.matches();

        Integer smallerNumber = Integer.parseInt(matcher.group(1));
        Integer largerNumber = Integer.parseInt(matcher.group(2));

        Character character = matcher.group(3).charAt(0);
        String password = matcher.group(4);

        Policy policy = new Policy(new IntPair(smallerNumber, largerNumber), character, indexInterpretation);

        return new PasswordEntry(policy, password);
    }
}
