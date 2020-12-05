package com.swamwithturtles.boardingpass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeatManifest {

    private List<Integer> manifest;

    public SeatManifest(Set<Integer> numbers) {
        this.manifest = numbers.stream().sorted().collect(Collectors.toList());;
    }

    public Integer findMissingNumber() {
        Integer minSeat = manifest.get(0);
        Integer maxSeat = manifest.get(manifest.size() - 1);

        List<Integer> range = IntStream.range(minSeat, maxSeat)
                .boxed()
                .collect(Collectors.toList());

        range.removeAll(manifest);

        return range.stream()
                .filter(this::shouldTerminate)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    private Boolean shouldTerminate(Integer candidate) {
        return manifest.contains(candidate - 1) &&
               manifest.contains(candidate + 1);
    }

}
