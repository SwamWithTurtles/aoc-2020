package com.swamwithturtles.password;

import com.swamwithturtles.common.datastructure.IntPair;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.Test;

public class PasswordEntryTest {

    private static final String STUB_STRING = "asd";

    @Test
    public void canConstructPasswordEntry() {
        Policy alwaysFalse = new FakePasswordPolicy(false);
        PasswordEntry passwordEntry = new PasswordEntry(alwaysFalse, STUB_STRING);

        assertThat(passwordEntry).isNotNull();
    }

    @Test
    public void passwordIsNotCompliantIfPolicyReturnsFalse() {
        Policy alwaysFalse = new FakePasswordPolicy(false);
        PasswordEntry passwordEntry = new PasswordEntry(alwaysFalse, STUB_STRING);

        assertThat(passwordEntry.isCompliant()).isFalse();
    }

    @Test
    public void passwordIsCompliantIfPolicyReturnsTrue() {
        Policy alwaysTrue = new FakePasswordPolicy(true);
        PasswordEntry passwordEntry = new PasswordEntry(alwaysTrue, STUB_STRING);

        assertThat(passwordEntry.isCompliant()).isTrue();
    }

    private class FakePasswordPolicy extends Policy {
        private Boolean fake;

        public FakePasswordPolicy(Boolean fakedValue) {
            super(new IntPair(0, 0), "a".charAt(0), IndexInterpretation.FREQUENCY);
            this.fake = fakedValue;
        }

        @Override
        public Boolean isCompliant(String possiblePassword) {
            return fake;
        }
    }

}
