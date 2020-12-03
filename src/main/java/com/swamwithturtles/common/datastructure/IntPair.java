package com.swamwithturtles.common.datastructure;

public class IntPair extends Pair<Integer, Integer> implements Arithmeticable {
    public IntPair(Integer first, Integer second) {
        super(first, second);
    }

    public static IntPair from(Pair<Integer, Integer> pair) {
        return new IntPair(pair.getFirst(), pair.getSecond());
    }

    @Override
    public Integer sum() {
        return getFirst() + getSecond();
    }

    @Override
    public Integer product() {
        return getFirst() * getSecond();
    }


}
