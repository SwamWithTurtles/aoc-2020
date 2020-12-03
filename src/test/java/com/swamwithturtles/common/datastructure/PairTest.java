package com.swamwithturtles.common.datastructure;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class PairTest {

    @Test
    public void pairCanBeConstructed() {
        Pair<String, Integer> pair = new Pair<>("ASD", 123);

        assertThat(pair.getFirst()).isEqualTo("ASD");
        assertThat(pair.getSecond()).isEqualTo(123);
    }

    @Test
    public void equalsAndHashcode() {
        Pair<String, Integer> pair1 = new Pair<>("ASD", 123);
        Pair<String, Integer> pair2 = new Pair<>("ASD", 123);
        Pair<Integer, String> differentPair = new Pair<>(123, "ASD");

        assertThat(pair1).isEqualTo(pair2);
        assertThat(pair2).isEqualTo(pair1);

        assertThat(pair1).isNotEqualTo(differentPair);

        assertThat(pair1.hashCode()).isEqualTo(pair2.hashCode());
        assertThat(pair1.hashCode()).isNotEqualTo(differentPair.hashCode());
    }
}
