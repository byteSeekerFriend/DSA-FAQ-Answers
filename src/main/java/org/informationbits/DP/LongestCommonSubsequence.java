package org.informationbits.DP;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {
    public static int getLCSLength(String s1, String s2) {
        int[][] dpMem = new int[2][s2.length() + 1];
        int prev = 0, curr = 1;
        Arrays.fill(dpMem[prev], 0);
        dpMem[curr][0] = 0;

        for (int r = 1; r <= s1.length(); r++) {
            for (int c = 1; c <= s2.length(); c++) {
                int lenIncluding = 0, lenExcluding = 0;
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) lenIncluding = 1 + dpMem[prev][c - 1];
                lenExcluding = Math.max(dpMem[curr][c - 1], dpMem[prev][c]);
                dpMem[curr][c] = Math.max(lenIncluding, lenExcluding);
            }
            prev = curr;
            curr = (curr + 1) % 2;
        }
        return dpMem[prev][s2.length()];
    }
}
