package org.informationbits.DP;

/**
 * https://leetcode.com/problems/01-matrix/description/
 */
public class ZeroOneMatrix {
    //Notice how beautifully matrix is processed to save space. Similarly, we could process if we have eight neighbours.
    public static int[][] updateMatrix(int[][] mat) {
        //This could also be used int MAX_VAL = mat.length+ mat[0].length;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) continue;
                int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                if (r - 1 >= 0) top = mat[r - 1][c];
                if (c - 1 >= 0) left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(top, left) + 1;
            }
        }

        for (int r = mat.length - 1; r >= 0; r--) {
            for (int c = mat[0].length - 1; c >= 0; c--) {
                int bottom = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if (r + 1 < mat.length) bottom = mat[r + 1][c];
                if (c + 1 < mat[0].length) right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}
