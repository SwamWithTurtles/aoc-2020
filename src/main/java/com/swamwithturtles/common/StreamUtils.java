package com.swamwithturtles.common;

import com.swamwithturtles.common.datastructure.Pair;
import com.swamwithturtles.common.datastructure.Triple;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

    public static <T, U>  Set<Pair<T, U>> cartesianProduct(Set<T> s1, Set<U> s2) {
        return s1.stream()
                .flatMap(s1Entry -> s2
                        .stream()
                        .flatMap(s2Entry -> Stream.of(new Pair<>(s1Entry, s2Entry)))
                )
                .collect(Collectors.toSet());
    }

    public static <T, U, V>  Set<Triple<T, U, V>> cartesianProduct(Set<T> s1, Set<U> s2, Set<V> s3) {
        return s1.stream()
                .flatMap(s1Entry -> s2
                        .stream()
                        .flatMap(s2Entry -> s3
                                .stream()
                                .flatMap(s3Entry -> Stream.of(new Triple<>(s1Entry, s2Entry, s3Entry))))
                )
                .collect(Collectors.toSet());
    }
}
