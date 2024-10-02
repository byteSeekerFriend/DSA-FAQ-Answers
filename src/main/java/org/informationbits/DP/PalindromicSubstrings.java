package org.informationbits.DP;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {
    private static int count = 0;

    public static int getPalindromicSubstringsCountV1(String s) {
        count = 0;
        if (s == null) return count;

        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i); // Odd Length
            extend(s, i, i + 1); // Even Length
        }
        return count;
    }

    private static void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
    }

    public static int getPalindromicSubstringsCountV2(String s) {

        count = 0;
        if (s == null) return count;
        boolean[][] dpMem = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dpMem[i], false);
            dpMem[i][i] = true;
            count++;
        }

        for (int i = 1; i < s.length(); i++) {
            int row = 0;
            for (int col = i; col < s.length(); col++) {
                if (s.charAt(row) == s.charAt(col) && (col - row == 1 || dpMem[row + 1][col - 1])) {
                    dpMem[row][col] = true;
                    count++;
                }
                row++;
            }
        }
        return count;
    }
}
