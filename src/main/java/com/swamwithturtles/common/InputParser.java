package com.swamwithturtles.common;

import com.google.common.io.Resources;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputParser {

    private final String fileName;

    public InputParser(String fileName) {
        this.fileName = fileName;
    }


    private String loadFromFile() throws IOException {
        URL url = Resources.getResource(fileName);
        return Resources.toString(url, StandardCharsets.UTF_8);
    }

    public Set<Integer> loadAsSetOfNumbers() throws IOException {
        String fileContents = loadFromFile();
        return Arrays.stream(fileContents.split("\n")).map(Integer::parseInt).collect(Collectors.toSet());
    }

}
