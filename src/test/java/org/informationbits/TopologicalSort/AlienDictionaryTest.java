package org.informationbits.TopologicalSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlienDictionaryTest {

    @Test
    void getAlienOrder() {
        String[] words = new String[]{"ndx", "nars", "avgd", "dkal"};
        String actual = AlienDictionary.getAlienOrder(Arrays.asList(words));
        String expected = "";
        assertEquals(expected, actual);
    }
}