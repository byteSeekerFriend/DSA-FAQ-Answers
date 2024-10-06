package org.informationbits.Matrices;

/**
 * https://leetcode.com/problems/rotate-image/description/
 */
public class RotateImage {
    //swap up to down, then transpose (or transpose then swap right to left)
    // or we could rotate layer by layer.
    public static int[][] rotateImage(int[][] matrix) {
        transpose(matrix);
        flipLeftRight(matrix);
        return matrix;
    }

    private static void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            //Note - start and range
            for (int j = i; j < m[0].length; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }

    private static void flipLeftRight(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            //Note - start and range
            for (int j = 0; j < m[0].length / 2; j++) {
                int tmp = m[i][j];
                m[i][j] = m[i][m[0].length - 1 - j];
                m[i][m[0].length - 1 - j] = tmp;
            }
        }
    }
}
