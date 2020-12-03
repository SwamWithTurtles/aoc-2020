package com.swamwithturtles.common.datastructure;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class IntTripleTest {
    private final static Integer FIRST = 8;
    private final static Integer SECOND = 9;
    private final static Integer THIRD = 10;

    @Test
    public void intPairCanStoreAndRetrieveIntegers() {

        IntTriple intPair = new IntTriple(FIRST, SECOND ,THIRD);

        assertThat(intPair.getFirst()).isEqualTo(FIRST);
        assertThat(intPair.getSecond()).isEqualTo(SECOND);
        assertThat(intPair.getThird()).isEqualTo(THIRD);
    }

    @Test
    public void intPairCanStoreAndRetrieveIntegersFromPair() {
        IntTriple intPair = IntTriple.from(new Triple<>(FIRST, SECOND, THIRD));

        assertThat(intPair.getFirst()).isEqualTo(FIRST);
        assertThat(intPair.getSecond()).isEqualTo(SECOND);
        assertThat(intPair.getThird()).isEqualTo(THIRD);
    }

    @Test
    public void intPairCanSumMemberIntegers() {
        IntTriple intPair = new IntTriple(FIRST, SECOND, THIRD);

        assertThat(intPair.sum()).isEqualTo(FIRST + SECOND + THIRD);
    }

    @Test
    public void intPairCanMultiplyMemberIntegers() {
        IntTriple intPair = new IntTriple(FIRST, SECOND, THIRD);

        assertThat(intPair.product()).isEqualTo(FIRST * SECOND * THIRD);
    }
}
