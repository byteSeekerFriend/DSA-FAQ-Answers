package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubsequenceTest {

    @Test
    void getLCSLength() {
        int actual = LongestCommonSubsequence.getLCSLength("mango", "abcmangoxyz");
        int expected = 5;
        assertEquals(expected, actual);
    }
}