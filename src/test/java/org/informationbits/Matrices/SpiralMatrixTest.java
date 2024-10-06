package org.informationbits.Matrices;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrixTest {

    @Test
    void spiralOrder() {
        int[][] m = new int[][]{{1}, {2}};
        List<Integer> actual = SpiralMatrix.printSpiralV2(m);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        assertEquals(expected, actual);
    }
}