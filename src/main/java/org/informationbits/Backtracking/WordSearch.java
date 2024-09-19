package org.informationbits.Backtracking;

/**
 * https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {
    public static boolean isWordPossible(char[][] grid, String word) {
        if (word.length() == 0) return true;
        if (grid == null || grid.length == 0 || (grid.length * grid[0].length) < word.length()) return false;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (dfs(grid, word, 0, x, y)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, String word, int wordIndex, int gridX, int gridY) {
        // wordIndex == word.length() - 1 will be wrong condition.
        if (wordIndex == word.length()) return true;
        if (gridX < 0 || gridY < 0 || gridX > (grid.length - 1) || gridY > (grid[0].length - 1)) return false;
        if (grid[gridX][gridY] != word.charAt(wordIndex)) return false;

        grid[gridX][gridY] = '*';
        boolean isRemainingWordPossible = dfs(grid, word, wordIndex + 1, gridX + 1, gridY) || dfs(grid, word, wordIndex + 1, gridX - 1, gridY) || dfs(grid, word, wordIndex + 1, gridX, gridY + 1) || dfs(grid, word, wordIndex + 1, gridX, gridY - 1);
        grid[gridX][gridY] = word.charAt(wordIndex);
        return isRemainingWordPossible;
    }
}
