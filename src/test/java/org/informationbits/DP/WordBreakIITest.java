package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordBreakIITest {

    @Test
    void getDictWordCombinations() {
        String word = "magiclly";
        List<String> wordDict = Arrays.asList("ag", "al", "icl", "mag", "magic", "ly", "lly");
        List<String> actual = WordBreakII.getDictWordCombinationsTopDown(word, wordDict);
        List<String> expected = Arrays.asList("mag icl ly", "magic lly");
        assertEquals(actual, expected);
    }
}