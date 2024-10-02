package org.informationbits.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII {
    static String word;
    static List<String> wordDict;
    static Map<Integer, List<String>> dpMem;

    private static List<String> dfs(int wordIdx) {
        if (wordIdx == word.length()) {
            dpMem.put(wordIdx, List.of(""));
            return dpMem.get(wordIdx);
        }
        if (dpMem.containsKey(wordIdx)) return dpMem.get(wordIdx);

        for (String dictWrd : wordDict) {
            int indexAfterIncluding = wordIdx + dictWrd.length();
            if (!word.substring(wordIdx).startsWith(dictWrd) || indexAfterIncluding > word.length()) continue;
            dfs(indexAfterIncluding);
            if (!dpMem.containsKey(indexAfterIncluding)) continue;
            List<String> dictCombinations = dpMem.get(indexAfterIncluding);
            List<String> dictCombinationsIncludingWord = dpMem.getOrDefault(wordIdx, new ArrayList<String>());
            for (String combination : dictCombinations) {
                dictCombinationsIncludingWord.add(dictWrd + (combination.isEmpty() ? "" : " " + combination));
            }
            dpMem.put(wordIdx, dictCombinationsIncludingWord);
        }

        return dpMem.getOrDefault(wordIdx, new ArrayList<String>());
    }

    public static List<String> getDictWordCombinationsTopDown(String word, List<String> wordDict) {
        WordBreakII.word = word;
        WordBreakII.wordDict = wordDict;
        dpMem = new HashMap<Integer, List<String>>();
        return dfs(0);
    }

    public static List<String> getDictWordCombinationsBottomUp(String word, List<String> wordDict) {
        //DP memory to store the prefix combinations.
        List<List<String>> dpMem = new ArrayList<>(word.length() + 1);
        for (int i = 0; i <= word.length(); i++) {
            dpMem.add(new ArrayList<>());
        }

        dpMem.get(0).add("");

        for (int i = 1; i <= word.length(); i++) {
            String wordPrefix = word.substring(0, i);
            List<String> combinations = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                String suffixOfCurrPrefix = wordPrefix.substring(j);
                if (!wordDict.contains(suffixOfCurrPrefix)) continue;
                for (String prefixCombinationUsingDict : dpMem.get(j)) {
                    combinations.add(prefixCombinationUsingDict + (prefixCombinationUsingDict.isEmpty() ? "" : " ") + suffixOfCurrPrefix);
                }
            }
            dpMem.set(i, combinations);
        }
        return dpMem.get(word.length());
    }
}
