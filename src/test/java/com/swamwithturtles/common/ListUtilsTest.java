package com.swamwithturtles.common;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class ListUtilsTest {

    private final static List<Integer> LIST = Arrays.asList(1, 2, 3);

    @Test
    public void shouldChopOffOneHead() {
        List<Integer> observed = ListUtils.chopOffHeads(LIST, 1);

        assertThat(observed).containsExactly(2, 3);
    }

    @Test
    public void shouldChopOffMultipleHeads() {
        List<Integer> observed = ListUtils.chopOffHeads(LIST, 2);

        assertThat(observed).containsExactly(3);
    }

    @Test
    public void shouldChopOffNoHeads() {
        List<Integer> observed = ListUtils.chopOffHeads(LIST, 0);

        assertThat(observed).containsExactly(1, 2, 3);
    }

    @Test
    public void shouldChopOffMoreHeadsThanAListHas() {
        List<Integer> observed = ListUtils.chopOffHeads(LIST, 4);

        assertThat(observed).isEmpty();
    }

    @Test
    public void shouldChopOffAllTheHeads() {
        List<Integer> observed = ListUtils.chopOffHeads(LIST, 3);

        assertThat(observed).isEmpty();
    }
}
