package com.swamwithturtles.taboggan;

import com.swamwithturtles.common.ListUtils;
import com.swamwithturtles.common.datastructure.IntPair;
import java.util.List;

public class TreeMap {

    private final List<TreeRow> treeRows;
    private final Integer position;

    private TreeMap(List<TreeRow> treeRows, Integer position) {
        this.treeRows = treeRows;
        this.position = position;
    }

    public TreeMap(List<TreeRow> treeRows) {
        this.treeRows = treeRows;
        this.position = 0;
    }

    public Integer numberOfTreesHit(IntPair slope) {
        if(treeRows.isEmpty()) {
            return 0;
        }

        TreeRow currentRow = treeRows.get(0);
        List<TreeRow> restOfMap = ListUtils.chopOffHeads(treeRows, slope.getSecond());

        if(currentRow.hasTreeAtPosition(position)) {
            return 1 + new TreeMap(restOfMap, position + slope.getFirst()).numberOfTreesHit(slope);
        } else {
            return new TreeMap(restOfMap, position + slope.getFirst()).numberOfTreesHit(slope);
        }
    }


}
