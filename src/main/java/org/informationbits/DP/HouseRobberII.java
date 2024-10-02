package org.informationbits.DP;

/*
 * https://leetcode.com/problems/house-robber-ii/solutions/
 * */
public class HouseRobberII {
    public static int getMaxAmountV2(int[] money) {
        if (money == null || money.length == 0) return 0;
        if (money.length == 1) return money[0];
        if (money.length == 2) return Math.max(money[0], money[1]);

        int[][] dpMem = new int[money.length][money.length];
        for (int j = 0; j < money.length; j++) {
            int row = 0, col = j;
            for (int i = j; i < money.length; i++) {
                if (row == col) dpMem[row][col] = money[col];
                else if (col - row == 1) dpMem[row][col] = Math.max(dpMem[row + 1][col], dpMem[row][col - 1]);
                else {
                    dpMem[row][col] = Math.max(dpMem[row][col - 1], money[col] + dpMem[row][col - 2]);
                }
                row++;
                col++;
            }
        }

        return Math.max(money[0] + dpMem[2][money.length - 2], dpMem[1][money.length - 1]);
    }

    public static int getMaxAmountV1(int[] money) {
        if (money == null || money.length == 0) return 0;
        if (money.length == 1) return money[0];
        if (money.length == 2) return Math.max(money[0], money[1]);

        return Math.max(getMaxAmtInLinearArray(money, 1, money.length - 1),
                getMaxAmtInLinearArray(money, 0, money.length - 2));
    }

    private static int getMaxAmtInLinearArray(int[] money, int start, int end) {
        if (money == null || money.length == 0 || start < 0 || end < start) return 0;
        if (start == end) return money[start];

        int prevIncluding = money[start], prevExcluding = 0;
        for (int i = start + 1; i <= end; i++) {
            int currIncluding = prevExcluding + money[i];
            int currExcluding = Math.max(prevIncluding, prevExcluding);
            prevExcluding = currExcluding;
            prevIncluding = currIncluding;
        }
        return Math.max(prevIncluding, prevExcluding);
    }
}
