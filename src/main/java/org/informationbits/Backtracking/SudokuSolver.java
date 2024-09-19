package org.informationbits.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/sudoku-solver/description/
 */
public class SudokuSolver {

    public static char[][] solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return board;
        List<int[]> emptySlots = findEmptySlots(board);
        explore(board, emptySlots);
        return board;
    }

    private static boolean explore(char[][] board, List<int[]> emptySlots) {
        if (emptySlots.size() == 0) return true;

        int[] slot = emptySlots.remove(0);
        for (char c = '1'; c <= '9'; c++) {
            if (isPossibleV1(board, slot, c)) {
                board[slot[0]][slot[1]] = c;
                if (explore(board, emptySlots)) {
                    //importance of reverting state.
                    emptySlots.add(0, slot);
                    return true;
                }
                //importance of reverting state.
                board[slot[0]][slot[1]] = '.';
            }
        }
        emptySlots.add(0, slot);
        return false;
    }

    private static boolean isPossibleV1(char[][] board, int[] slot, char numChar) {
        for (int i = 0; i < 9; i++) {
            if (board[i][slot[1]] == numChar) return false;
            if (board[slot[0]][i] == numChar) return false;
            // Style of checking.
            if (board[3 * (slot[0] / 3) + i / 3][3 * (slot[1] / 3) + i % 3] == numChar) return false;
        }
        return true;
    }

    private static boolean isPossibleV2(char[][] board, int[] slot, char numChar) {
        for (int i = 0; i < board.length; i++) {
            if (board[slot[0]][i] == numChar || board[i][slot[1]] == numChar) return false;
        }

        int cx = -1, cy = -1;
        int[][] threeCrossThreeCenters = new int[][]{{1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7}, {7, 1}, {7, 4}, {7, 7}};
        for (int[] xy : threeCrossThreeCenters) {
            int diffX = Math.abs(xy[0] - slot[0]), diffY = Math.abs(xy[1] - slot[1]);
            if (diffX <= 1 && diffX >= 0 && diffY <= 1 && diffY >= 0) {
                cx = xy[0];
                cy = xy[1];
            }
        }

        assert (cx != -1 && cy != -1);
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (board[cx + r][cy + c] == numChar) return false;
            }
        }
        return true;
    }

    private static List<int[]> findEmptySlots(char[][] board) {
        List<int[]> emptySlots = new LinkedList<int[]>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') emptySlots.add(new int[]{r, c});
            }
        }
        return emptySlots;
    }
}
