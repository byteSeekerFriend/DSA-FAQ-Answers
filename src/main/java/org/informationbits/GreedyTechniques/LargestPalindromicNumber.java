package org.informationbits.GreedyTechniques;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-palindromic-number/description/
 */
public class LargestPalindromicNumber {
    public static String largestPalindrome(String nums) {
        int[] numToCount = getNumToCount(nums);
        StringBuffer buffer = new StringBuffer();
        StringBuffer middle = new StringBuffer();
        for (int i = 9; i >= 0; i--) {
            char num = (char) ('0' + i);
            if (numToCount[i] % 2 != 0 && middle.length() == 0) {
                middle.append(num);
            }
            repeat(buffer, num, numToCount[i] / 2);
        }
        String prefix = buffer.toString();
        String suffix = buffer.reverse().toString();
        //prefix.charAt('0') would not work (if nothing in prefix) and middle length will be zero for even count.
        if (prefix.startsWith("0")) return middle.length() > 0 ? middle.toString() : "0";
        return prefix + middle + suffix;
    }

    private static int[] getNumToCount(String nums) {
        int[] numToCount = new int[10];
        Arrays.fill(numToCount, 0);
        for (char c : nums.toCharArray()) {
            numToCount[c - '0']++;
        }
        return numToCount;
    }

    private static void repeat(StringBuffer sb, char c, int count) {
        for (int j = 0; j < count; j++) {
            sb.append(c);
        }
    }
}
