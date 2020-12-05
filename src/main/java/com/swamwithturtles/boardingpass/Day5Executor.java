package com.swamwithturtles.boardingpass;

import com.swamwithturtles.common.InputParser;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Day5Executor {

    public static void main(String[] args) throws IOException {
        Set<String> input = new InputParser("day5.txt").loadAsSetOfStrings("\n");

        Set<Integer> takenSeats = input.stream()
                .map(Seat::fromString)
                .mapToInt(Seat::getSeatNumber)
                .boxed()
                .collect(Collectors.toSet());

        Integer maxSeatNumber = takenSeats
                .stream()
                .mapToInt(s -> s)
                .max().orElse(0);

        System.out.println("Day 1");
        System.out.println(maxSeatNumber);


        System.out.println("Day 2");
        System.out.println(new SeatManifest(takenSeats).findMissingNumber());




    }

}
