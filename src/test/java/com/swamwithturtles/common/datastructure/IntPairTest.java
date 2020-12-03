package com.swamwithturtles.common.datastructure;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class IntPairTest {
    private final static Integer FIRST = 8;
    private final static Integer SECOND = 9;

    @Test
    public void intPairCanStoreAndRetrieveIntegers() {

        IntPair intPair = new IntPair(FIRST, SECOND);

        assertThat(intPair.getFirst()).isEqualTo(FIRST);
        assertThat(intPair.getSecond()).isEqualTo(SECOND);
    }

    @Test
    public void intPairCanStoreAndRetrieveIntegersFromPair() {
        IntPair intPair = IntPair.from(new Pair<>(FIRST, SECOND));

        assertThat(intPair.getFirst()).isEqualTo(FIRST);
        assertThat(intPair.getSecond()).isEqualTo(SECOND);
    }

    @Test
    public void intPairCanSumMemberIntegers() {
        IntPair intPair = new IntPair(FIRST, SECOND);

        assertThat(intPair.sum()).isEqualTo(FIRST + SECOND);
    }

    @Test
    public void intPairCanMultiplyMemberIntegers() {
        IntPair intPair = new IntPair(FIRST, SECOND);

        assertThat(intPair.product()).isEqualTo(FIRST * SECOND);
    }
}
