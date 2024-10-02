package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecodeWaysTest {

    @Test
    void countPossibleDecoding() {
        int actual = DecodeWays.countPossibleDecoding("1003");
        assertEquals(0, actual);
    }
}