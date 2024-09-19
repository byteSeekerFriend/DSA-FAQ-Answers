package org.informationbits.GreedyTechniques;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/two-city-scheduling/description/
 */
public class TwoCityScheduling {
    public static int getMinCost(int[][] costs) {
        assert (costs.length % 2 == 0);
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] costPair1, int[] costPair2) {
                int diffOne = costPair1[0] - costPair1[1];
                int diffTwo = costPair2[0] - costPair2[1];
                return diffOne - diffTwo;
            }
        });
        int totalMinCost = 0;
        for (int i = 0; i < costs.length; i++) {
            totalMinCost += (i < costs.length / 2) ? costs[i][0] : costs[i][1];
        }
        return totalMinCost;
    }

    public static int getMinCostV2(int[][] costs) {
        assert (costs.length % 2 == 0);

        Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] costPair1, Integer[] costPair2) {
                int diffOne = Math.abs(costPair1[1] - costPair1[0]);
                int diffTwo = Math.abs(costPair2[1] - costPair2[0]);
                return diffOne - diffTwo;
            }
        };
        PriorityQueue<Integer[]> minCostX = new PriorityQueue<Integer[]>(comparator);
        PriorityQueue<Integer[]> minCostY = new PriorityQueue<Integer[]>(comparator);

        for (int i = 0; i < costs.length; i++) {
            if (costs[i][0] < costs[i][1]) minCostX.add(new Integer[]{costs[i][0], costs[i][1]});
            else minCostY.add(new Integer[]{costs[i][0], costs[i][1]});
        }

        while (minCostX.size() > costs.length / 2) {
            minCostY.add(minCostX.poll());
        }
        while (minCostY.size() > costs.length / 2) {
            minCostX.add(minCostY.poll());
        }
        assert (minCostX.size() == minCostY.size());

        int totalMinCost = 0;
        for (int i = 0; i < costs.length; i++) {
            totalMinCost += (i < costs.length / 2) ? minCostX.poll()[0] : minCostY.poll()[1];
        }
        return totalMinCost;
    }
}
