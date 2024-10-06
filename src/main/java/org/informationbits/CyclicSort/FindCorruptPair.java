package org.informationbits.CyclicSort;

/**
 * https://medium.com/data-structures-and-algorithms-dsa/find-the-corrupt-pair-a6da94927461
 */
public class FindCorruptPair {
    public static int[] findBadPair(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            // Note nums[index] -1 != index might result in infinite loop in some cases
            // e.g. - [1,1]  we are swapping with the same number.
            if (nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            } else {
                index++;
            }
        }

        index = 0;
        while (index < nums.length) {
            if (nums[index] - 1 != index) return new int[]{index + 1, nums[index]};
            index++;
        }
        return new int[]{};
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
