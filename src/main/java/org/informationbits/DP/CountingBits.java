package org.informationbits.DP;

/**
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {
    public static int[] getOneBitCount(int n) {
        int[] dpMem = new int[n + 1];
        dpMem[0] = 0;
        for (int i = 1; i <= n; i++) {
            //dpMem[i >> 1] + (i & 1) and dpMem[i >> 1] + i & 1 will produce different result.
            dpMem[i] = dpMem[i >> 1] + (i & 1);
        }
        return dpMem;
    }
}
