package com.swamwithturtles.boardingpass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class SeatManifestTest {

    @Test
    public void findsMissingNumberBetweenTwoSeats() {
        SeatManifest manifest = new SeatManifest(seatList(2, 4));

        assertThat(manifest.findMissingNumber()).isEqualTo(3);
    }

    @Test
    public void canIgnorePrefixedAndPostfixedNumber() {
        SeatManifest manifest = new SeatManifest(seatList(98, 99, 100, 101, 102, 104, 105, 106, 107));

        assertThat(manifest.findMissingNumber()).isEqualTo(103);
    }

    @Test
    public void ignoresLargeGapsInNumbers() {
        SeatManifest manifest = new SeatManifest(seatList(1, 5, 10, 12, 16, 25));

        assertThat(manifest.findMissingNumber()).isEqualTo(11);
    }

    private Set<Integer> seatList(Integer... seatNumbers) {
        Set<Integer> numbers = new HashSet<>();

        numbers.addAll(Arrays.asList(seatNumbers));

        return numbers;
    }


}
