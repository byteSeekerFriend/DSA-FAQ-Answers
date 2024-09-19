package org.informationbits.GreedyTechniques;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestPalindromicNumberTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void largestPalindrome() {
        String input = "111222333";
        String actual = LargestPalindromicNumber.largestPalindrome(input);
        String expected = "3213123";
        assertEquals(actual, expected);
    }
}