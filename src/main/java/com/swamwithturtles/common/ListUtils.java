package com.swamwithturtles.common;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T> List<T> chopOffHeads(List<T> list, Integer numberOfRowsToRemove) {
        if(list.size() < numberOfRowsToRemove) {
            return new ArrayList<>();
        }
        return list.subList(numberOfRowsToRemove, list.size());
    }
}
