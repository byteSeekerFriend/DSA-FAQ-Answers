package org.informationbits.Matrices;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
    public static int[][] setMatrixZeros(int[][] mat) {
        boolean rZero = false, cZero = false;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) continue;
                if (i == 0) rZero = true;
                //Putting if else will give incorrect result.
                if (j == 0) cZero = true;
                if (i != 0 && j != 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) mat[i][j] = 0;
            }
        }
        if (rZero) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[0][j] = 0;
            }
        }
        if (cZero) {
            for (int i = 0; i < mat.length; i++) {
                mat[i][0] = 0;
            }
        }
        return mat;
    }
}
