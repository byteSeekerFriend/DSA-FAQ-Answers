package org.informationbits.Backtracking;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matchsticks-to-square/description/
 * https://en.wikipedia.org/wiki/Partition_problem#:~:text=The%20partition%20problem%20is%20a,half%20the%20sum%20of%20S).
 */
public class MatchsticksToSquare {
    public static boolean isSquarePossible(int[] matchsticks) {
        int perimeter = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            perimeter += matchsticks[i];
        }
        if (perimeter % 4 != 0) return false;
        int sqrSideLen = perimeter / 4;

        //Just to Speed Up.
        Arrays.sort(matchsticks);

        for (int i = 0; i < matchsticks.length; i++) {
            if (matchsticks[i] > sqrSideLen) return false;
        }

        int[] sides = new int[4];
        return solve(matchsticks, sides, matchsticks.length - 1, sqrSideLen);
    }

    private static boolean solve(int[] matchsticks, int[] sides, int index, int sqrSideLen) {
        if (sides[0] == sqrSideLen && sides[0] == sides[1] && sides[1] == sides[2]) return true;
        for (int sideIdx = 0; sideIdx < sides.length; sideIdx++) {

            //Notice this optimization using DP concept in NP complete Problem to reduce exploration.
            int prevSideIdx = sideIdx - 1;
            for (; prevSideIdx >= 0; prevSideIdx--) {
                if (sides[sideIdx] == sides[prevSideIdx]) break;
            }

            if (prevSideIdx != -1 || sides[sideIdx] + matchsticks[index] > sqrSideLen) continue;
            sides[sideIdx] += matchsticks[index];
            if (solve(matchsticks, sides, index - 1, sqrSideLen)) {
                sides[sideIdx] -= matchsticks[index];
                return true;
            }
            sides[sideIdx] -= matchsticks[index];
        }
        return false;
    }
}
