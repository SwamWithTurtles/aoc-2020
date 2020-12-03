package com.swamwithturtles.common.datastructure;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Test;

public class TripleTest {

    @Test
    public void tripleCanBeConstructed() {
        Triple<String, Integer, String> pair = new Triple<>("ASD", 123, "DEF");

        assertThat(pair.getFirst()).isEqualTo("ASD");
        assertThat(pair.getSecond()).isEqualTo(123);
        assertThat(pair.getThird()).isEqualTo("DEF");
    }

    @Test
    public void equalsAndHashcode() {
        Triple<String, Integer, String> triple1 = new Triple<>("ASD", 123, "DEF");
        Triple<String, Integer, String> triple2 = new Triple<>("ASD", 123, "DEF");

        Triple<Integer, String, String> differentTriple = new Triple<>(123, "ASD", "DEF");

        assertThat(triple1).isEqualTo(triple2);
        assertThat(triple2).isEqualTo(triple1);

        assertThat(triple1).isNotEqualTo(differentTriple);

        assertThat(triple1.hashCode()).isEqualTo(triple2.hashCode());
        assertThat(triple1.hashCode()).isNotEqualTo(differentTriple.hashCode());
    }
}
