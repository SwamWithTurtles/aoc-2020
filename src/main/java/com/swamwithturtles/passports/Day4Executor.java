package com.swamwithturtles.passports;

import com.swamwithturtles.common.InputParser;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Day4Executor {

    public static void main(String[] args) throws IOException {
        Set<String> input = new InputParser("day4.txt").loadAsSetOfStrings("\n\n");

        long numberOfPassportsWithAllFields = input.stream()
                .map(PassportDetails::parse)
                .filter(details -> details.isValid(ValidationType.PRESENCE))
                .count();

        System.out.println("Day 1");
        System.out.println(numberOfPassportsWithAllFields);

        long numberOfValidPassports = input.stream()
                .map(PassportDetails::parse)
                .filter(details -> details.isValid(ValidationType.SEMANTIC))
                .count();

        System.out.println("Day 2");
        System.out.println(numberOfValidPassports);
    }
}
