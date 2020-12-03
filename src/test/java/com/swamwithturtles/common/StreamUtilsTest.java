package com.swamwithturtles.common;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.swamwithturtles.common.datastructure.Pair;
import com.swamwithturtles.common.datastructure.Triple;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class StreamUtilsTest {

    private <T> Set<T> setFrom(T... strings) {
        return Arrays.stream(strings)
                .collect(Collectors.toSet());
    }

    @Test
    public void cartesianProductCanJoinTwoSets() {
        Set<String> firstSet = setFrom("A", "B");
        Set<Integer> secondSet = setFrom(1, 2, 3);

        Set<Pair<String, Integer>> pairs = StreamUtils.cartesianProduct(firstSet, secondSet);

        assertThat(pairs).containsExactlyInAnyOrder(
                new Pair<>("A", 1),
                new Pair<>("A", 2),
                new Pair<>("A", 3),
                new Pair<>("B", 1),
                new Pair<>("B", 2),
                new Pair<>("B", 3)
        );
    }

    @Test
    public void cartesianProductCanJoinTwoSetsIfOneIsEmpty() {
        Set<String> firstSet = setFrom("A", "B");
        Set<Integer> secondSet = setFrom();

        Set<Pair<String, Integer>> pairs = StreamUtils.cartesianProduct(firstSet, secondSet);

        assertThat(pairs).isEmpty();
    }

    @Test
    public void cartesianProductCanJoinThreeSets() {
        Set<String> firstSet = setFrom("A", "B");
        Set<Integer> secondSet = setFrom(1, 2, 3);
        Set<Boolean> thirdSet = setFrom(true, false);

        Set<Triple<String, Integer, Boolean>> triples = StreamUtils.cartesianProduct(firstSet, secondSet, thirdSet);

        assertThat(triples).containsExactlyInAnyOrder(
                new Triple<>("A", 1, true),
                new Triple<>("A", 2, true),
                new Triple<>("A", 3, true),
                new Triple<>("B", 1, true),
                new Triple<>("B", 2, true),
                new Triple<>("B", 3, true),
                new Triple<>("A", 1, false),
                new Triple<>("A", 2, false),
                new Triple<>("A", 3, false),
                new Triple<>("B", 1, false),
                new Triple<>("B", 2, false),
                new Triple<>("B", 3, false)
        );
    }

    @Test
    public void cartesianProductCanJoinThreeSetsIfOneIsEmpty() {
        Set<String> firstSet = setFrom("A", "B");
        Set<Integer> secondSet = setFrom();
        Set<Boolean> thirdSet = setFrom(true, false);

        Set<Triple<String, Integer, Boolean>> triples = StreamUtils.cartesianProduct(firstSet, secondSet, thirdSet);

        assertThat(triples).isEmpty();
    }
}
