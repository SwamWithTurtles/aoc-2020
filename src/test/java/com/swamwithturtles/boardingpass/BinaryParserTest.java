package com.swamwithturtles.boardingpass;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class BinaryParserTest {

    @Test
    public void canParseSingleOneDigit() {
        BinaryParser parser = new BinaryParser("I");

        assertThat(parser.parse("O", "I")).isEqualTo(1);
    }

    @Test
    public void canParseSingleZeroDigit() {
        BinaryParser parser = new BinaryParser("O");

        assertThat(parser.parse("O", "I")).isEqualTo(0);
    }

    @Test
    public void canParseComplexStringOfBinary() {
        BinaryParser parser = new BinaryParser("IIOOIIOO");

        assertThat(parser.parse("O", "I")).isEqualTo(4 + 8 + 64 + 128);
    }
}
