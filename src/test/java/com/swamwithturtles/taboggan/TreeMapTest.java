package com.swamwithturtles.taboggan;

import com.swamwithturtles.common.datastructure.IntPair;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TreeMapTest {

    @Test
    public void canConstructTreeMap() {
        List<TreeRow> treeRows = Arrays.asList(
                TreeRow.fromString("..."),
                TreeRow.fromString("###")
        );

        TreeMap map = new TreeMap(treeRows);

        assertThat(map).isNotNull();
    }

    @Test
    public void emptyTreeMapHasZeroTreesHit() {
        List<TreeRow> treeRows = Collections.emptyList();

        TreeMap map = new TreeMap(treeRows);

        assertThat(map.numberOfTreesHit(new IntPair(1, 1))).isEqualTo(0);
    }

    @Test
    public void singleRowTreeMapHasAHitIfTreeIsInFirstPosition() {
        List<TreeRow> treeRows = Arrays.asList(
                TreeRow.fromString("###")
        );

        TreeMap map = new TreeMap(treeRows);

        assertThat(map.numberOfTreesHit(new IntPair(1, 1))).isEqualTo(1);
    }

    @Test
    public void singleRowTreeMapHasNoHitIfTreeIsInFirstPosition() {
        List<TreeRow> treeRows = Arrays.asList(
                TreeRow.fromString("...")
        );

        TreeMap map = new TreeMap(treeRows);

        assertThat(map.numberOfTreesHit(new IntPair(1, 1))).isEqualTo(0);
    }

    @Test
    public void canTranscendThroughRowsOfFullTrees() {
        List<TreeRow> treeRows = Arrays.asList(
                TreeRow.fromString("###"),
                TreeRow.fromString("###"),
                TreeRow.fromString("###"),
                TreeRow.fromString("###")
        );

        TreeMap map = new TreeMap(treeRows);

        assertThat(map.numberOfTreesHit(new IntPair(1, 1))).isEqualTo(4);
    }

    @Test
    public void canTranscendThroughRowsOfNoTrees() {
        List<TreeRow> treeRows = Arrays.asList(
                TreeRow.fromString("...."),
                TreeRow.fromString("...."),
                TreeRow.fromString("...."),
                TreeRow.fromString("....")
        );

        TreeMap map = new TreeMap(treeRows);

        assertThat(map.numberOfTreesHit(new IntPair(1, 1))).isEqualTo(0);
    }

    @Test
    public void canTranscendThroughRowsOfHalfTrees() {
        List<TreeRow> treeRows = Arrays.asList(
                TreeRow.fromString("###"),
                TreeRow.fromString("..."),
                TreeRow.fromString("..."),
                TreeRow.fromString("###")
        );

        TreeMap map = new TreeMap(treeRows);

        assertThat(map.numberOfTreesHit(new IntPair(1, 1))).isEqualTo(2);
    }

    @Test
    public void canTranscendThroughRowsMoreThanOneAtATime() {
        List<TreeRow> treeRows = Arrays.asList(
                TreeRow.fromString("...."),
                TreeRow.fromString("####"),
                TreeRow.fromString("...."),
                TreeRow.fromString("####"),
                TreeRow.fromString("...."),
                TreeRow.fromString("####"),
                TreeRow.fromString("....")
        );

        TreeMap map = new TreeMap(treeRows);

        assertThat(map.numberOfTreesHit(new IntPair(2, 2))).isEqualTo(0);
    }
}
