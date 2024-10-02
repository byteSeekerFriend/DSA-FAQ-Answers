package org.informationbits.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {
    public static List<List<Integer>> getCombinationsV2(int[] nums, int target) {
        List<List<Integer>>[] dpMem = new List[target + 1];
        for (int i = 0; i < dpMem.length; i++) {
            dpMem[i] = new ArrayList<List<Integer>>();
        }

        List<Integer> combinationForZero = new ArrayList<Integer>();
        dpMem[0].add(combinationForZero);

        for (int num : nums) {
            for (int t = num; t <= target; t++) {
                if (dpMem[t - num].size() > 0) {
                    List<List<Integer>> combinations = cloneListOfList(dpMem[t - num]);
                    for (List<Integer> combination : combinations) {
                        combination.add(num);
                    }
                    dpMem[t].addAll(combinations);
                }
            }
        }
        return dpMem[target];
    }


    public static List<List<Integer>> getCombinationsV1(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> dpMem = new HashMap<Integer, List<List<Integer>>>();
        List<Integer> combinationForZero = new ArrayList<Integer>();
        List<List<Integer>> combinationsForZero = new ArrayList<List<Integer>>();
        combinationsForZero.add(combinationForZero);
        dpMem.put(0, combinationsForZero);

        for (int num : nums) {
            //Avoid concurrent and modification in the same map.
            Map<Integer, List<List<Integer>>> dpMemClone = cloneMap(dpMem);
            List<Integer> timesNum = new ArrayList<>();
            timesNum.add(num);
            while (true) {
                boolean numAdded = false;
                for (int sum : dpMem.keySet()) {
                    int newSum = sum + timesNum.size() * num;
                    if (newSum > target) continue;
                    List<List<Integer>> cloneCombinations = cloneListOfList(dpMem.get(sum));
                    for (List<Integer> combination : cloneCombinations) {
                        combination.addAll(timesNum);
                    }
                    List<List<Integer>> combinations = dpMemClone.getOrDefault(newSum, new ArrayList<List<Integer>>());
                    combinations.addAll(cloneCombinations);

                    dpMemClone.put(newSum, combinations);
                    numAdded = true;
                }
                if (!numAdded) break;

                timesNum.add(num);
            }
            dpMem = dpMemClone;
        }
        return dpMem.getOrDefault(target, new ArrayList<List<Integer>>());
    }

    private static Map<Integer, List<List<Integer>>> cloneMap(Map<Integer, List<List<Integer>>> map) {
        Map<Integer, List<List<Integer>>> cloneMap = new HashMap<Integer, List<List<Integer>>>();
        for (int key : map.keySet()) {
            cloneMap.put(key, cloneListOfList(map.get(key)));
        }
        return cloneMap;
    }

    private static List<List<Integer>> cloneListOfList(List<List<Integer>> lists) {
        List<List<Integer>> newLists = new ArrayList<List<Integer>>();
        for (List<Integer> l : lists) {
            List<Integer> newL = new ArrayList<Integer>();
            for (Integer i : l) {
                newL.add(i);
            }
            newLists.add(newL);
        }
        return newLists;
    }
}
