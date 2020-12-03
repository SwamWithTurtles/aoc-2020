package com.swamwithturtles.taboggan;

import com.swamwithturtles.common.InputParser;
import com.swamwithturtles.common.datastructure.IntPair;
import com.swamwithturtles.password.IndexInterpretation;
import com.swamwithturtles.password.PasswordEntry;
import com.swamwithturtles.password.PasswordParser;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3Executor {

    public static void main(String[] args) throws IOException {
        TreeMap treeMap = parseTreeMap();

        System.out.println("Part 1");
        System.out.println(treeMap.numberOfTreesHit(new IntPair(3, 1)));

        List<IntPair> possibleSlopes = Arrays.asList(
                new IntPair(1, 1),
                new IntPair(3, 1),
                new IntPair(5, 1),
                new IntPair(7, 1),
                new IntPair(1, 2)
        );

        Integer productOfStops = possibleSlopes.stream()
                .mapToInt(treeMap::numberOfTreesHit)
                .reduce(1, (a, b) -> a * b);

        System.out.println("Part 2");
        System.out.println(productOfStops);
    }

    private static TreeMap parseTreeMap() throws IOException {
        List<String> input = new InputParser("day3.txt").loadAsListOfStrings();

        List<TreeRow> treeRows = input.stream()
                .map(TreeRow::fromString)
                .collect(Collectors.toList());

        return new TreeMap(treeRows);
    }

}
