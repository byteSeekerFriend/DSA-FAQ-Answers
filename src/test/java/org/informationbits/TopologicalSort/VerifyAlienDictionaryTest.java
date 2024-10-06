package org.informationbits.TopologicalSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VerifyAlienDictionaryTest {

    @Test
    void verifyAlienDictionary() {

        String[] words = new String[]{"iupyter", "ascending"};
        String order = "iabcdefghjklmnopqrstuvwxyz";
        boolean actual = VerifyAlienDictionary.isInProvidedLexOrder(words, order);
        assertTrue(actual);
    }
}