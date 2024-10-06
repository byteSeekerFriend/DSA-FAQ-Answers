package org.informationbits.CyclicSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstMissingPositiveTest {

    @Test
    void getMissingLeastPositiveInteger() {
        int[] nums = new int[]{3, 4, -1, 1};
        int actual = FirstMissingPositive.getMissingLeastPositiveInteger(nums);
        int expected = 2;
        assertEquals(expected, actual);
    }
}