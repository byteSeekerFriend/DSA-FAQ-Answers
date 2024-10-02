package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CntGoodSubsequencesNumberTest {

    @Test
    void getGoodSubsequencesCnt() {
        int actual = CntGoodSubsequencesNumber.getGoodSubsequencesCnt("aabb");
        int expected = 11;
        assertEquals(expected, actual);
    }
}