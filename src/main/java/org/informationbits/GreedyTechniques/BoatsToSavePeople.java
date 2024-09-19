package org.informationbits.GreedyTechniques;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/boats-to-save-people/description/
 */
public class BoatsToSavePeople {
    public static int rescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, boatCnt = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit && left != right) {
                left++;
                right--;
            } else {
                right--;
            }
            boatCnt++;
        }
        return boatCnt;
    }
}
