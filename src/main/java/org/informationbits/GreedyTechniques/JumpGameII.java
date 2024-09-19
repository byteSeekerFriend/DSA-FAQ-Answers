package org.informationbits.GreedyTechniques;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class JumpGameII {
    //No need of heap because we need max only.
    public static int getMinJumps(int[] nums) {
        int currJumpEnd = 0, nextJumpEnd = 0, minJumps = 0;
        //No need to check the last index.
        for (int i = 0; i < nums.length - 1; i++) {
            nextJumpEnd = Math.max(i + nums[i], nextJumpEnd);
            if (currJumpEnd == i) {
                //Position of this condition is improtant.
                if (currJumpEnd >= nums.length - 1) return minJumps;

                //case when we can not reach the end.
                if (nextJumpEnd == i) return -1;
                currJumpEnd = nextJumpEnd;
                minJumps++;
            }
        }
        return minJumps;
    }
}
