package org.informationbits.DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {
    public static boolean couldBreak(String s, List<String> words) {
        Set<String> wordDict = new HashSet<String>();
        wordDict.addAll(words);

        boolean[] dpMem = new boolean[s.length() + 1];
        dpMem[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            if (dpMem[i]) break;
            for (int j = 0; j <= i; j++) {
                if (dpMem[j] && wordDict.contains(s.substring(j, i))) {
                    dpMem[i] = true;
                    break;
                }
            }
        }
        return dpMem[s.length()];
    }
}
