package org.informationbits.Matrices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhereWillBallFallTest {

    @Test
    void findExitColumn() {
        int[][] grid = new int[][]{{-1, -1}, {1, 1}};
        int[] actual = WhereWillBallFall.getFinalExitColumn(grid);
        int[] expected = new int[]{-1, 1};
        assertEquals(expected, actual);
    }
}