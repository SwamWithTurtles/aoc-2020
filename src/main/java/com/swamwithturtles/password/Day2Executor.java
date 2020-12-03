package com.swamwithturtles.password;

import com.swamwithturtles.common.InputParser;
import com.swamwithturtles.expenses.Expenses;
import java.io.IOException;
import java.util.Set;

public class Day2Executor {

    public static void main(String[] args) throws IOException {
        Set<String> input = new InputParser("day2.txt").loadAsSetOfStrings();


        long numberOfCompliantPasswordsWithFrequencyPolicy = input.stream()
                .map(p -> PasswordParser.parse(IndexInterpretation.FREQUENCY, p))
                .filter(PasswordEntry::isCompliant)
                .count();

        System.out.println("Part 1");
        System.out.println(numberOfCompliantPasswordsWithFrequencyPolicy);

        long numberOfCompliantPasswordsWithPositionPolicy = input.stream()
                .map(p -> PasswordParser.parse(IndexInterpretation.POSITION, p))
                .filter(PasswordEntry::isCompliant)
                .count();

        System.out.println("Part 2");
        System.out.println(numberOfCompliantPasswordsWithPositionPolicy);

    }

}
