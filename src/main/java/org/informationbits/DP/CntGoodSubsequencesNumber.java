package org.informationbits.DP;

import java.util.Arrays;

/**
 * [*****]
 * https://algo.monster/liteproblems/2539
 * https://www.interviewbit.com/problems/count-good-subsequences/?amp=1
 */

public class CntGoodSubsequencesNumber {
    private static final int MOD = 1000000007;
    private static int MAX_CHAR_FREQ = 0;

    private static int[] charFreq;
    private static int[] factorials;
    private static int[] inverseModulos;

    private static char[] chars;

    private static void populateCharFreq() {
        charFreq = new int[26];
        Arrays.fill(charFreq, 0);
        MAX_CHAR_FREQ = 0;
        for (char c : chars) {
            charFreq[c - 'a']++;
            if (charFreq[c - 'a'] > MAX_CHAR_FREQ) MAX_CHAR_FREQ = charFreq[c - 'a'];
        }
    }

    private static void populateFactorials() {
        factorials = new int[MAX_CHAR_FREQ + 1];
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = mul(factorials[i - 1], i);
        }
    }

    private static void populateInverseModulo() {
        inverseModulos = new int[MAX_CHAR_FREQ + 1];
        for (int i = 0; i < inverseModulos.length; i++) {
            inverseModulos[i] = getInverseModulo(factorials[i]);
        }
    }

    //Inverse Modulo using Fermat's Little Theorem.
    public static int getInverseModulo(int num) {
        int times = MOD - 2;
        int res = 1;
        while (times > 0) {
            if ((times & 1) == 1) res = mul(res, num);
            num = mul(num, num);
            times = times >> 1;
        }
        return res;
    }

    private static int mul(int a, int b) {
        //Notice - Importance of (long) and respective brackets. It is used to avoid overflow.
        return (int) ((long) a * b % MOD);
    }

    private static void init(String s) {
        chars = s.toCharArray();
        populateCharFreq();
        populateFactorials();
        populateInverseModulo();
    }

    public static int getGoodSubsequencesCnt(String s) {
        init(s);
        int totalCnt = 0;
        for (int f = 1; f <= MAX_CHAR_FREQ; f++) {
            int cnt = 0;
            for (int ci = 0; ci < 26; ci++) {
                int charF = charFreq[ci];
                if (charF < f) continue;
                int combination = mul(
                        mul(factorials[charF], inverseModulos[f]),
                        inverseModulos[charF - f]);
                cnt = cnt == 0 ? (combination + 1) : mul(cnt, (combination + 1));
            }
            cnt--;
            if (cnt == 0) continue;
            totalCnt = (totalCnt + cnt) % MOD;
        }
        return totalCnt;
    }
}
