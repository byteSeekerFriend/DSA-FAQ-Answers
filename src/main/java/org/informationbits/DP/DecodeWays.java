package org.informationbits.DP;

/**
 * https://leetcode.com/problems/decode-ways/description/
 */
public class DecodeWays {

    //checking from forward direction might not be elegant.
    public static int countPossibleDecoding(String encodedSrt) {
        if (encodedSrt == null || encodedSrt.isEmpty()) return 0;

        int[] dpMem = new int[2];
        int next = 0, nextNext = 1;
        dpMem[next] = encodedSrt.charAt(encodedSrt.length() - 1) == '0' ? 0 : 1;
        dpMem[nextNext] = 1;

        for (int i = encodedSrt.length() - 2; i >= 0; i--) {
            int possibleWay = encodedSrt.charAt(i) == '0' ? 0 : dpMem[next];
            if (encodedSrt.charAt(i) == '1' ||
                    encodedSrt.charAt(i) == '2' && encodedSrt.charAt(i + 1) < '7') {
                possibleWay += dpMem[nextNext];
            }
            dpMem[nextNext] = dpMem[next];
            dpMem[next] = possibleWay;
        }
        return dpMem[next];
    }
}
