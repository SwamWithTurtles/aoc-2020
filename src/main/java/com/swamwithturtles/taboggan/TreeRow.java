package com.swamwithturtles.taboggan;

import java.util.List;
import java.util.stream.Collectors;

public class TreeRow {

    private List<Boolean> hasTrees;

    private TreeRow(List<Boolean> hasTrees) {
        this.hasTrees = hasTrees;
    }

    public static TreeRow fromString(String trees) {
        List<Boolean> treePositions = trees.chars()
                .mapToObj(i -> (char)i)
                .map(i -> i == "#".charAt(0))
                .collect(Collectors.toList());

        return new TreeRow(treePositions);
    }

    public boolean hasTreeAtPosition(Integer pos) {
        Integer modularPosition = pos % hasTrees.size();
        return hasTrees.get(modularPosition);
    }
}
