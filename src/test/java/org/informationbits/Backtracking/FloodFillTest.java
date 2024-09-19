package org.informationbits.Backtracking;

import org.junit.jupiter.api.Test;

class FloodFillTest {

    @Test
    void floodFill() {
        int[][] grid = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill.floodFill(grid, 1, 1, 2);


        grid = new int[][]{{1, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 1, 0}, {1, 0, 1, 0}};
        FloodFill.floodFill(grid, 2, 3, 0);
    }
}