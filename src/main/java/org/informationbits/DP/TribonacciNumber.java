package org.informationbits.DP;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/description/
 */
public class TribonacciNumber {
    public static int findTribonacci(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;
        int[] dpMem = new int[n + 1];
        dpMem[0] = 0;
        dpMem[1] = 1;
        dpMem[2] = 1;
        for (int i = 3; i <= n; i++) {
            dpMem[i] = dpMem[i - 1] + dpMem[i - 2] + dpMem[i - 3];
        }
        return dpMem[n];
    }
}
