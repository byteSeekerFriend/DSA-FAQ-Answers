package org.informationbits.DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseRobberIITest {

    @Test
    void getMaxAmount() {
        int[] money = new int[]{2, 3, 2};
        int actual = HouseRobberII.getMaxAmountV1(money);
        int expected = 3;
        assertEquals(expected, actual);
    }
}