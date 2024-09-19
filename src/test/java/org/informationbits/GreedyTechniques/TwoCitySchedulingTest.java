package org.informationbits.GreedyTechniques;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoCitySchedulingTest {

    @Test
    void getMinCostV2() {
        int[][] costs = new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        int costActual = TwoCityScheduling.getMinCostV2(costs);
        int costExpected = 1859;
        assertEquals(costExpected, costActual);
    }

    @Test
    void getMinCost() {
        int[][] costs = new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
        int costActual = TwoCityScheduling.getMinCost(costs);
        int costExpected = 1859;
        assertEquals(costExpected, costActual);
    }
}