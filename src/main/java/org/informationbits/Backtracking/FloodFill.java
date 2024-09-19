package org.informationbits.Backtracking;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {
    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        if (sr >= 0 && sc >= 0 && sr < grid.length && sc < grid[0].length) dfs(grid, sr, sc, grid[sr][sc], target);
        return grid;
    }

    private static void dfs(int[][] grid, int rowIdx, int colIdx, int source, int target) {
        if (rowIdx < 0 || colIdx < 0 || rowIdx > grid.length - 1 || colIdx > grid[0].length - 1) return;
        //Note - we could remove grid[rowIdx][colIdx] == target when source != target or target is some value which is not reachable by the flood.
        if (grid[rowIdx][colIdx] != source || grid[rowIdx][colIdx] == target) return;

        grid[rowIdx][colIdx] = target;

        for (int[] diff : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
            dfs(grid, rowIdx + diff[0], colIdx + diff[1], source, target);
        }
    }
}

