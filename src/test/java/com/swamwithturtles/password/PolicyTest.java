package com.swamwithturtles.password;

import com.swamwithturtles.common.datastructure.IntPair;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class PolicyTest {

    @Test
    public void canConstructPolicy() {
        Policy policy = new Policy(new IntPair(1, 3), 'a', IndexInterpretation.FREQUENCY);

        assertThat(policy).isNotNull();
        assertThat(policy.getFrequency()).isEqualTo(new IntPair(1, 3));
        assertThat(policy.getCharacter()).isEqualTo('a');
        assertThat(policy.getInterpretation()).isEqualTo(IndexInterpretation.FREQUENCY);
    }

    @Test
    public void frequencyPolicyPassesWhenItShould() {
        Policy policy = new Policy(new IntPair(1, 3), 'a', IndexInterpretation.FREQUENCY);

        assertThat(policy.isCompliant("aa")).isTrue();
    }

    @Test
    public void frequencyPolicyFailsIfItHasNoInstancesOfCharacter() {
        Policy policy = new Policy(new IntPair(1, 3), 'a', IndexInterpretation.FREQUENCY);

        assertThat(policy.isCompliant("bb")).isFalse();
    }

    @Test
    public void frequencyPolicyFailsIfItHasTooFewInstancesOfCharacter() {
        Policy policy = new Policy(new IntPair(2, 7), 'a', IndexInterpretation.FREQUENCY);

        assertThat(policy.isCompliant("abcde")).isFalse();
    }

    @Test
    public void frequencyPolicyFailsIfItHasTooManyInstancesOfCharacter() {
        Policy policy = new Policy(new IntPair(2, 7), 'a', IndexInterpretation.FREQUENCY);

        assertThat(policy.isCompliant("aaaaaaaaa")).isFalse();
    }

    @Test
    public void policyPolicyFailsIfItHasNoRelevantCharacters() {
        Policy policy = new Policy(new IntPair(2, 7), 'a', IndexInterpretation.POSITION);

        assertThat(policy.isCompliant("axaaaax")).isFalse();
    }

    @Test
    public void policyPolicyPassesIfItHasFirstRelevantCharacters() {
        Policy policy = new Policy(new IntPair(2, 7), 'a', IndexInterpretation.POSITION);

        assertThat(policy.isCompliant("aaaaaax")).isTrue();
    }

    @Test
    public void policyPolicyPassesIfItHasSecondRelevantCharacters() {
        Policy policy = new Policy(new IntPair(2, 7), 'a', IndexInterpretation.POSITION);

        assertThat(policy.isCompliant("axaaaaa")).isTrue();
    }

    @Test
    public void policyPolicyFailsIfItHasBothRelevantCharacters() {
        Policy policy = new Policy(new IntPair(2, 7), 'a', IndexInterpretation.POSITION);

        assertThat(policy.isCompliant("aaaaaaa")).isFalse();
    }
}
