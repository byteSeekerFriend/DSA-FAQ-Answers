package org.informationbits.Matrices;

import java.util.ArrayList;
import java.util.List;

/**
 * [***]
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {
    public static List<Integer> printSpiralV1(int[][] matrix) {
        int currRows = matrix.length, currCols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int moveDirection = 1;
        //style of coding.
        int rowIndex = 0, colIndex = -1;
        while (currRows > 0 && currCols > 0) {
            for (int i = 0; i < currCols; i++) {
                colIndex += moveDirection;
                result.add(matrix[rowIndex][colIndex]);
            }
            currRows--;
            for (int i = 0; i < currRows; i++) {
                rowIndex += moveDirection;
                result.add(matrix[rowIndex][colIndex]);
            }
            currCols--;
            moveDirection *= -1;
        }
        return result;
    }

    public static List<Integer> printSpiralV2(int[][] m) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int rowS = 0, rowE = m.length - 1, colS = 0, colE = m[0].length - 1;
        while (rowS <= rowE && colS <= colE) {
            pRowLR(m, rowS++, colS, colE, res);
            pColTB(m, colE--, rowS, rowE, res);
            if (rowS <= rowE) pRowRL(m, rowE--, colE, colS, res);
            if (colS <= colE) pColBT(m, colS++, rowE, rowS, res);
        }
        return res;
    }

    //pRowLR ->  printPowLeftToRight similarly.
    private static void pRowLR(int[][] m, int r, int colS, int colE, List<Integer> res) {
        for (int i = colS; i <= colE; i++) {
            res.add(m[r][i]);
        }
    }

    private static void pColTB(int[][] m, int c, int rowS, int rowE, List<Integer> res) {
        for (int i = rowS; i <= rowE; i++) {
            res.add(m[i][c]);
        }
    }

    private static void pRowRL(int[][] m, int r, int colE, int colS, List<Integer> res) {
        for (int i = colE; i >= colS; i--) {
            //note which index is moving.
            res.add(m[r][i]);
        }
    }

    private static void pColBT(int[][] m, int c, int rowE, int rowS, List<Integer> res) {
        for (int i = rowE; i >= rowS; i--) {
            res.add(m[i][c]);
        }
    }
}
