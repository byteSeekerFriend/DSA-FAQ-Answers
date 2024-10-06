package org.informationbits.CyclicSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstKMissingPositiveNumbersTest {

    @Test
    void getfirstKMissingNumbers() {
        int[] nums = new int[]{1, 2, 5};
        int k = 6;
        List<Integer> actual = FirstKMissingPositiveNumbers.getfirstKMissingNumbers(nums, k);
        List<Integer> expected = Arrays.asList(3, 4, 6, 7, 8, 9);
        assertEquals(expected, actual);
    }
}