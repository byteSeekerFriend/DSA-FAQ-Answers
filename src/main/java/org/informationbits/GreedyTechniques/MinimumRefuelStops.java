package org.informationbits.GreedyTechniques;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
 */
public class MinimumRefuelStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> currMaxFuelStation = new PriorityQueue<Integer>(Collections.reverseOrder());
        int currFuel = startFuel;
        int stopCount = 0;
        int processedStation = 0;
        while (true) {
            if (currFuel >= target) return stopCount;
            while (processedStation < stations.length && currFuel >= stations[processedStation][0]) {
                currMaxFuelStation.add(stations[processedStation][1]);
                processedStation++;
            }
            if (currMaxFuelStation.size() <= 0) return -1;
            currFuel += currMaxFuelStation.poll();
            stopCount++;
        }
    }
}
