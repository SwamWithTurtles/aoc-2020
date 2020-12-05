package com.swamwithturtles.boardingpass;

public class BinaryParser {

    private String stringToParse;

    public BinaryParser(String stringToParse) {
        this.stringToParse = stringToParse;
    }

    public Integer parse(String zero, String one) {
        if(stringToParse.length() == 0) {
            return 0;
        }

        Integer leastSignificantDigit;
        if(this.stringToParse.substring(stringToParse.length() - 1).equals(zero)) {
            leastSignificantDigit = 0;
        } else {
            leastSignificantDigit = 1;
        }

        String rest = this.stringToParse.substring(0, stringToParse.length() - 1);

        return leastSignificantDigit + 2 * new BinaryParser(rest).parse(zero, one);
    }
}
