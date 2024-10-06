package org.informationbits.CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-first-k-natural-numbers-missing-given-array/
 * We are doing it without sorting but using extra space.
 */
public class FirstKMissingPositiveNumbers {

    public static List<Integer> getfirstKMissingNumbers(int[] arr, int k) {
        int[] nums = new int[arr.length + k];
        Arrays.fill(nums, 0);
        int index = 0;
        while (index < arr.length) {
            nums[index] = arr[index++];
        }
        index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] <= nums.length && nums[nums[index] - 1] != nums[index]) {
                swap(nums, nums[index] - 1, index);
            } else {
                index++;
            }
        }

        index = 0;
        List<Integer> res = new ArrayList<Integer>();
        while (res.size() < k) {
            if (index < nums.length) {
                if (nums[index] != index + 1) res.add(index + 1);
            } else {
                res.add(index + 1);
            }
            index++;
        }
        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
