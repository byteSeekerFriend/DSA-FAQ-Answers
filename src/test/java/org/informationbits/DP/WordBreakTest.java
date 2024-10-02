package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordBreakTest {

    @Test
    void couldBreak() {
        String[] words = new String[]{"let", "us", "code"};
        boolean actual = WordBreak.couldBreak("usletcode", Arrays.asList(words));
        boolean expected = true;
        assertEquals(expected, actual);
    }

}