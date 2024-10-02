package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductSubarrayTest {

    @Test
    void maxProduct() {
        int[] nums = new int[]{2, 3, 2, 4};
        int actual = MaximumProductSubarray.maxProductV2(nums);
        int expected = 6;
        assertEquals(actual, expected);
    }
}