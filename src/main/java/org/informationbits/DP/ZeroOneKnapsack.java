package org.informationbits.DP;

/**
 * https://leetcode.com/discuss/study-guide/1152328/01-Knapsack-Problem-and-Dynamic-Programming
 */
public class ZeroOneKnapsack {
    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        //It could be solved with 1-D array as well. Because we just check previous values.
        int[][] dpMem = new int[weights.length + 1][capacity + 1];
        for (int wI = 1; wI < dpMem.length; wI++) {
            dpMem[wI][0] = 0;
        }
        for (int cI = 1; cI < dpMem[0].length; cI++) {
            dpMem[0][cI] = 0;
        }

        for (int wI = 1; wI < dpMem.length; wI++) {
            for (int cI = 1; cI < dpMem[0].length; cI++) {
                dpMem[wI][cI] = dpMem[wI - 1][cI];
                //weights[wI - 1] not weights[wI]
                if (cI - weights[wI - 1] >= 0)
                    dpMem[wI][cI] = Math.max(dpMem[wI][cI], dpMem[wI - 1][cI - weights[wI - 1]] + values[wI - 1]);
            }
        }
        return dpMem[weights.length][capacity];
    }
}
