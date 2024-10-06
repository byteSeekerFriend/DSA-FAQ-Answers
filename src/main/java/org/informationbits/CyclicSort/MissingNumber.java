package org.informationbits.CyclicSort;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public static int getMissingNumberV2(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == index || arr[index] > arr.length - 1 || arr[index] < 0) index++;
            else if (arr[index] != index) {
                int swapIndex = arr[index];
                arr[index] = arr[swapIndex];
                arr[swapIndex] = swapIndex;
            }
        }

        for (index = 0; index < arr.length; index++) {
            if (arr[index] != index) break;
        }
        return index;
    }

    /**
     * Observation - If number n (== arr.length) is not present in the array means there is no missing number.
     */
    public static int getMissingNumberV1(int[] arr) {
        int xorResult = 0, i = 0;
        for (i = 0; i < arr.length; i++) {
            xorResult = xorResult ^ arr[i] ^ i;
        }
        return xorResult ^ arr.length;
    }
}
