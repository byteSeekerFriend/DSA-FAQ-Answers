package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    @Test
    void coinChange() {
        int[] coins = new int[]{2, 3, 4, 6, 8};
        int total = 23;
        int actual = CoinChange.coinChange(coins, total);
        int expected = 4;
        assertEquals(expected, actual);
    }
}