package org.informationbits.TopologicalSort;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 */
public class VerifyAlienDictionary {
    private static final int ENG_ALPHABET_CNT = 26;

    public static boolean isInProvidedLexOrder(String[] words, String order) {
        assert (order.length() == 26);
        int[] alphabetPos = new int[ENG_ALPHABET_CNT];
        for (int i = 0; i < ENG_ALPHABET_CNT; i++) {
            alphabetPos[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (!isInLexOrder(words[i - 1], words[i], alphabetPos)) return false;
        }
        return true;
    }

    private static boolean isInLexOrder(String wP, String wN, int[] alphabetPosition) {
        for (int i = 0; i < wP.length() && i < wN.length(); i++) {
            if (wP.charAt(i) != wN.charAt(i))
                return alphabetPosition[wP.charAt(i) - 'a'] < alphabetPosition[wN.charAt(i) - 'a'];
        }
        return wP.length() < wN.length();
    }
}
