package org.informationbits.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/description/
 */
public class SpreadStonesOverGrid {

    private static int minCost;

    private static int fill(List<XYStones> sources, List<XYStones> destinations, int cost) {
        for (int i = 0; i < sources.size(); i++) {
            XYStones src = sources.removeFirst();
            XYStones dest = destinations.removeFirst();

            int costSToD = (Math.abs(src.y - dest.y) + Math.abs(src.x - dest.x));

            if (src.stoneCnt > 1) {
                sources.addFirst(new XYStones(src.x, src.y, src.stoneCnt - 1));
            }
            cost += costSToD;
            fill(sources, destinations, cost);

            if (destinations.size() == 0) {
                if (cost < minCost) minCost = cost;
            }

            cost -= costSToD;
            if (src.stoneCnt > 1) sources.removeFirst();
            sources.addLast(src);
            destinations.addFirst(dest);
        }
        return minCost;
    }

    public static int minimumMoves(int[][] grid) {
        minCost = Integer.MAX_VALUE;
        List<XYStones> sources = new LinkedList<XYStones>();
        List<XYStones> destinations = new LinkedList<XYStones>();


        for (int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            for (int colIdx = 0; colIdx < grid[0].length; colIdx++) {
                if (grid[rowIdx][colIdx] == 0) destinations.add(new XYStones(rowIdx, colIdx, 0));
                if (grid[rowIdx][colIdx] > 1) sources.add(new XYStones(rowIdx, colIdx, grid[rowIdx][colIdx] - 1));
            }
        }
        //We can also check source has enough to fill the destinations or not.
        if (destinations.size() > 0) fill(sources, destinations, 0);
        return destinations.size() == 0 ? 0 : minCost;
    }

    private static class Mapping {
        int srcX, srcY;
        int destX, destY;

        public Mapping(XYStones dest, XYStones src) {
            this.srcX = src.x;
            this.srcY = src.y;
            this.destX = dest.x;
            this.destY = dest.y;
        }
    }

    private static class XYStones {
        int x, y, stoneCnt;

        XYStones(int a, int b, int count) {
            x = a;
            y = b;
            stoneCnt = count;
        }
    }

}
/**
 * Notes -
 * - Issues due to map modification in the loop.
 * - Some collection need implementation of comparable [compareTo]
 * - Result could be at any depth of recursion.
 */
