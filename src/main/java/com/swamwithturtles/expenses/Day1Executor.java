package com.swamwithturtles.expenses;

import com.swamwithturtles.common.InputParser;
import java.io.IOException;
import java.util.Set;

public class Day1Executor {

    public static void main(String[] args) throws IOException {
        Set<Integer> input = new InputParser("day1.txt").loadAsSetOfNumbers();

        Expenses expenses = new Expenses(input);

        System.out.println("Part 1");
        System.out.println(expenses.findProductOfTwoExpenses());

        System.out.println("Part 2");
        System.out.println(expenses.findProductOfThreeExpenses());

    }

}
