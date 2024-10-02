package org.informationbits.DP;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {
    public static int countDistinctWay(int n) {
        //Important Condition.
        if (n <= 1) return 1;
        int[] dpMem = new int[2];
        int secondLast = 0, last = 1;
        dpMem[secondLast] = 1;
        dpMem[last] = 2;
        for (int i = 3; i <= n; i++) {
            int waysToPositionI = dpMem[last] + dpMem[secondLast];
            dpMem[secondLast] = dpMem[last];
            dpMem[last] = waysToPositionI;
        }
        return dpMem[last];
    }
}
