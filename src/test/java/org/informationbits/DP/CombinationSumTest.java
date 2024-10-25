package org.informationbits.DP;

import org.junit.jupiter.api.Test;

class CombinationSumTest {

    @Test
    void getCombinations() {
        int[] nums = new int[]{4, 5, 2};
        CombinationSum.getCombinationsV2(nums, 16);
    }
}