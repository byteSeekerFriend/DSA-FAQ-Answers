package org.informationbits.TopologicalSort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {

    public static boolean canFinishCourses(int numCourses, int[][] prerequisites) {
        Node[] graph = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new Node(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0], from = prerequisites[i][1];
            graph[to].inDegree.add(from);
            graph[from].outDegree.add(to);
        }

        Queue<Integer> qu = new LinkedList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].inDegree.size() == 0) qu.add(i);
        }

        int courseCnt = 0;
        while (!qu.isEmpty()) {
            int index = qu.remove();
            courseCnt++;
            for (int out : graph[index].outDegree) {
                graph[out].inDegree.remove(index);
                //Note - In case of loop, such node will not be picked.
                if (graph[out].inDegree.size() == 0) qu.add(out);
            }
        }
        return courseCnt == graph.length;
    }

    static class Node {
        int n;
        Set<Integer> inDegree;
        Set<Integer> outDegree;

        Node(int index) {
            n = index;
            inDegree = new HashSet<Integer>();
            outDegree = new HashSet<Integer>();
        }
    }
}
