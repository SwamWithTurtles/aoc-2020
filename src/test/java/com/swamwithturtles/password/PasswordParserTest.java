package com.swamwithturtles.password;

import com.swamwithturtles.common.datastructure.IntPair;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class PasswordParserTest {

    @Test
    public void constructsPasswordFromSimpleString() {
        PasswordEntry passwordEntry = PasswordParser.parse(IndexInterpretation.FREQUENCY, "2-4 x: xxxx");

        assertThat(passwordEntry.getPassword()).isEqualTo("xxxx");
        assertThat(passwordEntry.getPasswordPolicy().getCharacter()).isEqualTo('x');
        assertThat(passwordEntry.getPasswordPolicy().getFrequency().getFirst()).isEqualTo(2);
        assertThat(passwordEntry.getPasswordPolicy().getFrequency().getSecond()).isEqualTo(4);
        assertThat(passwordEntry.getPasswordPolicy().getInterpretation()).isEqualTo(IndexInterpretation.FREQUENCY);
    }

    @Test
    public void constructsPasswordWithTwoDigitIndexes() {
        PasswordEntry passwordEntry = PasswordParser.parse(IndexInterpretation.POSITION, "12-14 x: xxxx");

        assertThat(passwordEntry.getPassword()).isEqualTo("xxxx");
        assertThat(passwordEntry.getPasswordPolicy().getCharacter()).isEqualTo('x');
        assertThat(passwordEntry.getPasswordPolicy().getFrequency().getFirst()).isEqualTo(12);
        assertThat(passwordEntry.getPasswordPolicy().getFrequency().getSecond()).isEqualTo(14);
        assertThat(passwordEntry.getPasswordPolicy().getInterpretation()).isEqualTo(IndexInterpretation.POSITION);
    }

    @Test
    public void constructsPasswordWithShortPassword() {
        PasswordEntry passwordEntry = PasswordParser.parse(IndexInterpretation.FREQUENCY, "1-2 x: a");

        assertThat(passwordEntry.getPassword()).isEqualTo("a");
        assertThat(passwordEntry.getPasswordPolicy().getCharacter()).isEqualTo('x');
        assertThat(passwordEntry.getPasswordPolicy().getFrequency().getFirst()).isEqualTo(1);
        assertThat(passwordEntry.getPasswordPolicy().getFrequency().getSecond()).isEqualTo(2);
        assertThat(passwordEntry.getPasswordPolicy().getInterpretation()).isEqualTo(IndexInterpretation.FREQUENCY);
    }
}
