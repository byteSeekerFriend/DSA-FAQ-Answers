package org.informationbits.DP;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange {
    public static int coinChange(int[] coins, int total) {
        int[] dpMem = new int[total + 1];
        Arrays.fill(dpMem, Integer.MAX_VALUE);
        dpMem[0] = 0;

        for (int cI = 0; cI < coins.length; cI++) {
            for (int tI = coins[cI]; tI <= total; tI++) {
                if (dpMem[tI - coins[cI]] != Integer.MAX_VALUE)
                    dpMem[tI] = Math.min(dpMem[tI], dpMem[tI - coins[cI]] + 1);
            }
        }
        return dpMem[total] == Integer.MAX_VALUE ? -1 : dpMem[total];
    }
}
