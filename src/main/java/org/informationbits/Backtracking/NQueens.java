package org.informationbits.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public static int solveNQueens(int n) {
        List<String> solutions = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer(n);
        dfs(solutions, buffer, 1, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return solutions.size();
    }

    private static void dfs(List<String> solutions, StringBuffer buffer, int x, Set<Integer> pickedYs, Set<Integer> xPlusY, Set<Integer> xMinusY) {
        if (buffer.length() == buffer.capacity()) {
            solutions.add(buffer.toString());
            return;
        }
        for (int y = 1; y <= buffer.capacity(); y++) {
            if (pickedYs.contains(y) || xPlusY.contains(x + y) || xMinusY.contains(x - y)) continue;

            buffer.append(y);
            pickedYs.add(y);
            xPlusY.add(x + y);
            xMinusY.add(x - y);
            dfs(solutions, buffer, x + 1, pickedYs, xPlusY, xMinusY);
            buffer.deleteCharAt(buffer.length() - 1);
            pickedYs.remove(y);
            xPlusY.remove(x + y);
            xMinusY.remove(x - y);
        }
    }
}
