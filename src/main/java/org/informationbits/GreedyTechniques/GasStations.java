package org.informationbits.GreedyTechniques;

/**
 * https://leetcode.com/problems/gas-station/description/
 */
public class GasStations {
    public static int findStartStation(int[] gas, int[] cost) {
        double total_surplus = 0, running_surplus = 0;
        int startStationIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            total_surplus += gas[i] - cost[i];
            running_surplus += gas[i] - cost[i];
            if (running_surplus < 0) {
                running_surplus = 0;
                startStationIndex = i + 1;
            }
        }
        return total_surplus < 0 ? -1 : startStationIndex;
    }
}
