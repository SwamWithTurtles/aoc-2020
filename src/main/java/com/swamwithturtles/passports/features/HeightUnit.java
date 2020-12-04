package com.swamwithturtles.passports.features;

public enum HeightUnit {
    INCHES("in"),
    CENTIMETERS("cm");

    HeightUnit(String s) {
        this.shorthand = s;
    }

    private String shorthand;

    public static HeightUnit fromShortHand(String text) {
        for (HeightUnit heightUnit : HeightUnit.values()) {
            if (heightUnit.shorthand.equalsIgnoreCase(text)) {
                return heightUnit;
            }
        }

        return null;
    }
}
