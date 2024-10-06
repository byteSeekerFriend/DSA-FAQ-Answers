package org.informationbits.CyclicSort;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class FirstMissingPositive {
    // Another approach could be try to fix one index at a time (means number in one cycle).
    public static int getMissingLeastPositiveInteger(int[] nums) {
        int i = 0;
        for (; i < nums.length; i++) {
            // Note - Using -> nums[i] - 1 != nums[i] alone will give TLE. Because whatever you are swapping are equal then swapping does not make sense.
            // or simply use num[i] != num[num[i]-1]
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) break;
        }

        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
