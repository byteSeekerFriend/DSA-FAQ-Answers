package org.informationbits.GreedyTechniques;

/**
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGameOne {

    public static boolean jumpGameVersionOne(int[] nums) {
        int maxIndexReachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndexReachable < i) return false;
            maxIndexReachable = Math.max(maxIndexReachable, i + nums[i]);
        }
        return true;
    }

    public static boolean jumpGameVersionTwo(int[] nums) {
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (target <= i + nums[i]) {
                target = i;
            }
        }
        return target == 0;
    }


//    public static boolean jumpGame(int[] nums) {
//        double sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (sum - i < 0) {
//                return false;
//            }
//            sum += nums[i];
//        }
//        return true;
//    }
}
