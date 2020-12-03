package com.swamwithturtles.password;

import com.google.common.base.CharMatcher;
import com.swamwithturtles.common.datastructure.IntPair;

public class Policy {
    private final IntPair frequency;
    private final Character character;
    private final IndexInterpretation interpretation;

    public Policy(IntPair frequency, Character character, IndexInterpretation indexInterpretation) {
        this.frequency = frequency;
        this.character = character;
        this.interpretation = indexInterpretation;
    }

    public Boolean isCompliant(String possiblePassword) {

        switch (interpretation) {
            case FREQUENCY:
                Integer numberOfMatches = CharMatcher.is(character).countIn(possiblePassword);
                return numberOfMatches >= frequency.getFirst() && numberOfMatches <= frequency.getSecond();
            case POSITION:
                return possiblePassword.charAt(frequency.getFirst() - 1) == character
                        ^ possiblePassword.charAt(frequency.getSecond() - 1) == character;
            default:
                return false;
        }
    }

    public IntPair getFrequency() {
        return frequency;
    }

    public Character getCharacter() {
        return character;
    }

    public IndexInterpretation getInterpretation() {
        return interpretation;
    }
}
