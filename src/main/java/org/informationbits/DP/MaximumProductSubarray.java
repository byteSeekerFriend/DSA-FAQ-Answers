package org.informationbits.DP;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {

    public static int maxProductV1(int[] nums) {
        if (nums == null)
            return 0;

        int maxProd = nums[0], currMinProd = nums[0], currMaxProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tMaxProd = currMaxProd * nums[i];
            int tMinProd = currMinProd * nums[i];
            currMaxProd = Math.max(nums[i], Math.max(tMaxProd, tMinProd));
            currMinProd = Math.min(nums[i], Math.min(tMaxProd, tMinProd));
            maxProd = Math.max(maxProd, currMaxProd);
        }
        return maxProd;
    }

    public static int maxProductV2(int[] nums) {
        if (nums == null) return 0;

        int maxProduct = nums[0], currPositiveProd = 0, currNegativeProd = 0;
        //pInit means positive product is not initialized.
        boolean pInit = false, nInit = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = currNegativeProd;
                currNegativeProd = currPositiveProd;
                currPositiveProd = tmp;

                boolean tmpInit = pInit;
                pInit = nInit;
                nInit = tmpInit;
            }

            if (pInit) {
                currPositiveProd = currPositiveProd == 0 ? (nums[i] > 0 ? nums[i] : 0) : currPositiveProd * nums[i];
            } else if (nums[i] >= 0) {
                pInit = true;
                currPositiveProd = nums[i];
            }

            if (nInit) {
                currNegativeProd = currNegativeProd == 0 ? (nums[i] < 0 ? nums[i] : 0) : currNegativeProd * nums[i];
            } else if (nums[i] <= 0) {
                nInit = true;
                currNegativeProd = nums[i];
            }

            if (pInit) maxProduct = Math.max(maxProduct, currPositiveProd);
            if (nInit) maxProduct = Math.max(maxProduct, currNegativeProd);
        }
        return maxProduct;
    }
}
