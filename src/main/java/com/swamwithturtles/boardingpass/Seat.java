package com.swamwithturtles.boardingpass;

public class Seat {

    private final Integer rowNumber;
    private final Integer seatNumber;

    public Seat(Integer rowNumber, Integer seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public static Seat fromString(String binaryString) {
        String rowDeterminer = binaryString.substring(0, 7);
        String seatDeterminer = binaryString.substring(7);

        return new Seat(
                new BinaryParser(rowDeterminer).parse("F", "B"),
                new BinaryParser(seatDeterminer).parse("L", "R")
        );
    }

    public Integer getSeatNumber() {
        return 8 * rowNumber + seatNumber;
    }
}
