package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromicSubstringsTest {

    @Test
    void getPalindromicSubstringsCountV2() {
        int actual = PalindromicSubstrings.getPalindromicSubstringsCountV1("PPP");
        int expected = 6;
        assertEquals(expected, actual);
    }
}