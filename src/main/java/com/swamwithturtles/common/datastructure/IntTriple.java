package com.swamwithturtles.common.datastructure;

public class IntTriple extends Triple<Integer, Integer, Integer> implements Arithmeticable {
    public IntTriple(Integer first, Integer second, Integer third) {
        super(first, second, third);
    }

    public static IntTriple from(Triple<Integer, Integer, Integer> triple) {
        return new IntTriple(triple.getFirst(), triple.getSecond(), triple.getThird());
    }

    @Override
    public Integer sum() {
        return getFirst() + getSecond() + getThird();
    }

    @Override
    public Integer product() {
        return getFirst()  * getSecond() * getThird();
    }
}
