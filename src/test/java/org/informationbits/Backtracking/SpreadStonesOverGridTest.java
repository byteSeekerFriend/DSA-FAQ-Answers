package org.informationbits.Backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpreadStonesOverGridTest {

    @Test
    void minimumMoves() {
        int[][] grid = new int[][]{{1, 3, 0}, {1, 0, 0}, {1, 0, 3}};
        int actual = SpreadStonesOverGrid.minimumMoves(grid);
        int expected = 4;
        assertEquals(actual, expected);
    }
}