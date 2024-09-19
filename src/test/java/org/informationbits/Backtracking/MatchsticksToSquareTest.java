package org.informationbits.Backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchsticksToSquareTest {

    @Test
    void isSquarePossible() {
        int[] matchsticks = new int[]{3, 4, 4, 1, 2, 2};
        boolean actual = MatchsticksToSquare.isSquarePossible(matchsticks);
        assertTrue(actual);
    }
}