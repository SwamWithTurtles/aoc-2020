package com.swamwithturtles.boardingpass;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class SeatTest {

    @Test
    public void canParseZeroSeat() {
        Seat seat = Seat.fromString("FFFFFFFLLL");

        assertThat(seat.getSeatNumber()).isEqualTo(0);

    }

    @Test
    public void canParseAllOneSeat() {
        Seat seat = Seat.fromString("BBBBBBBRRR");

        Integer seatNumber = 7 + 8 * (1 + 2 + 4 + 8 + 16 + 32 + 64);

        assertThat(seat.getSeatNumber()).isEqualTo(seatNumber);
    }

    @Test
    public void canParseComplexSeat() {
        Seat seat = Seat.fromString("BFFFFFBLLR");

        Integer seatNumber = 1 + 8 * (1 + 64);

        assertThat(seat.getSeatNumber()).isEqualTo(seatNumber);
    }

}
