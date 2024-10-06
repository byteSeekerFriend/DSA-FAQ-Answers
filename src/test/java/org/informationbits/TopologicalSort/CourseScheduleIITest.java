package org.informationbits.TopologicalSort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseScheduleIITest {

    @Test
    void findOrder() {
        int n = 3;
        int[][] prerequisites = new int[][]{{0, 1}, {2, 1}, {2, 0}, {0, 2}};
        List<Integer> actualOrder = CourseScheduleII.getCourseCompletionOrder(n, prerequisites);
        assertEquals(new ArrayList<>(), actualOrder);
    }
}