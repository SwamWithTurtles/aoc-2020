package com.swamwithturtles.taboggan;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TreeRowTest {

    @Test
    public void canConstructATreeRowWithNoTrees() {
        TreeRow treeRow = TreeRow.fromString("....");

        assertThat(treeRow).isNotNull();
    }

    @Test
    public void identifiesLackOfTrees() {
        TreeRow treeRow = TreeRow.fromString("....");

        assertThat(treeRow.hasTreeAtPosition(0)).isFalse();
    }

    @Test
    public void identifiesPresenceOfTrees() {
        TreeRow treeRow = TreeRow.fromString("####");

        assertThat(treeRow.hasTreeAtPosition(0)).isTrue();
    }

    @Test
    public void canDistinguishTreesFromNoTrees() {
        TreeRow treeRow = TreeRow.fromString("#..#");

        assertThat(treeRow.hasTreeAtPosition(0)).isTrue();
        assertThat(treeRow.hasTreeAtPosition(1)).isFalse();
        assertThat(treeRow.hasTreeAtPosition(2)).isFalse();
        assertThat(treeRow.hasTreeAtPosition(3)).isTrue();
    }
}
