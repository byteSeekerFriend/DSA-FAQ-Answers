package org.informationbits.TopologicalSort;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseScheduleII {
    public static List<Integer> getCourseCompletionOrder(int n, int[][] prerequisites) {
        Set<Integer> possibleOrder = new HashSet<Integer>();
        List<Set<Integer>> adjacencyList = new ArrayList<Set<Integer>>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<Integer>());
        }

        //Notice - Loop condition.
        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Queue<Integer> qu = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (adjacencyList.get(i).size() == 0) qu.add(i);
        }

        while (!qu.isEmpty()) {
            int course = qu.remove();
            possibleOrder.add(course);
            //Iterating over adjacency list might slow down the code because it's length is higher.
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] != course || possibleOrder.contains(prerequisites[i][0])) continue;
                adjacencyList.get(prerequisites[i][0]).remove(course);
                if (adjacencyList.get(prerequisites[i][0]).size() == 0) qu.add(prerequisites[i][0]);
            }
        }
        return possibleOrder.size() == n ? new ArrayList<Integer>(possibleOrder) : new ArrayList<Integer>();
    }
}
