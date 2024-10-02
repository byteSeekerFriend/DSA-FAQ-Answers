package org.informationbits.DP;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * */
public class PartitionEqualSubsetSum {
    public static boolean canPartitionArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) return false;
        int subSetSum = sum / 2;
        boolean[] dpMem = new boolean[subSetSum + 1];
        Arrays.fill(dpMem, false);
        dpMem[0] = true;
        for (int i = 0; i < arr.length; i++) {
            //We need to traverse in the reverse order.
            for (int j = subSetSum; j >= arr[i]; j--) {
                dpMem[j] = dpMem[j] || dpMem[j - arr[i]];
            }
        }
        return dpMem[subSetSum];
    }
}
