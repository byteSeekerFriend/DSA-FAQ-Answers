package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSumTest {

    @Test
    void getCombinations() {
        int[] nums = new int[]{4, 5, 2};
        List<List<Integer>> actual = CombinationSum.getCombinationsV2(nums, 16);
    }
}