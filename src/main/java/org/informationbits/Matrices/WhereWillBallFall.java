package org.informationbits.Matrices;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/description/
 */
public class WhereWillBallFall {
    public static int[] getFinalExitColumn(int[][] m) {
        int[] ballPos = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            ballPos[i] = i;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (ballPos[j] == -1) continue;
                int p = ballPos[j];
                if (m[i][p] == 1 && p + 1 < m[0].length && m[i][p] == m[i][p + 1]) ballPos[j] += 1;
                else if (m[i][p] == -1 && p - 1 >= 0 && m[i][p] == m[i][p - 1]) ballPos[j] -= 1;
                else ballPos[j] = -1;
            }
        }
        return ballPos;
    }
}
