package org.informationbits.Backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 */
public class RestoreIPAddressesWithMemory {
    private static final Map<Pair, Set<String>> dpMemory = new HashMap<Pair, Set<String>>();

    public static List<String> getIpAddresses(String s) {
        List<String> ipParts = new ArrayList<String>();
        dfsIPFinder(s, 0, ipParts);
        //dpMemory.get(new Pair(0, 4)) -> Give me all 4 part ip (means complete IP) from the index 0.
        return new ArrayList<String>(dpMemory.getOrDefault(new Pair(0, 4), new HashSet<String>()));
    }

    private static void memorizeSolution(List<String> ip) {
        int digitIndex = 0, ipPartCnt = ip.size();
        for (int ipPartIdx = 0; ipPartIdx < ip.size(); ipPartIdx++) {
            Pair indexAndPartCnt = new Pair(digitIndex, ipPartCnt--);
            Set<String> ipPartSet = dpMemory.getOrDefault(indexAndPartCnt, new HashSet<String>());
            ipPartSet.add(String.join(".", ip.subList(ipPartIdx, ip.size())));
            dpMemory.put(indexAndPartCnt, ipPartSet);
            digitIndex += ip.get(ipPartIdx).length();
        }
    }

    private static List<String> getSolutionFromMemorizedData(List<String> ipParts) {
        int digitIndex = 0;
        for (int i = 0; i < ipParts.size(); i++) {
            digitIndex += ipParts.get(i).length();
        }
        Set<String> partialIps = dpMemory.getOrDefault(new Pair(digitIndex, 4 - ipParts.size()), new HashSet<String>());
        if (partialIps.size() == 0) return new ArrayList<String>(partialIps);
        Set<String> completeIps = new HashSet<String>();
        for (String ip : partialIps) {
            //Importance of "."
            completeIps.add(String.join(".", ipParts) + "." + ip);
        }
        return new ArrayList<String>(completeIps);
    }

    private static void dfsIPFinder(String digits, int digitsIndex, List<String> ipParts) {
        if (ipParts.size() == 4) {
            if (digitsIndex == digits.length()) memorizeSolution(ipParts);
            return;
        }
        //Notice loop conditions
        for (int i = digitsIndex; i <= Math.min(digitsIndex + 2, digits.length() - 1); i++) {
            String ipPart = digits.substring(digitsIndex, i + 1);
            if (isInValidIPPart(ipPart)) break;

            ipParts.add(ipPart);
            List<String> solutionBasedOnMemorizedData = getSolutionFromMemorizedData(ipParts);
            if (solutionBasedOnMemorizedData.size() == 0) dfsIPFinder(digits, i + 1, ipParts);
            else {
                // Here just "." will give empty string. because "." is treated as a regex pattern, where . matches any character
                solutionBasedOnMemorizedData.stream().forEach(ip -> memorizeSolution(Arrays.asList(ip.split("\\."))));
            }
            ipParts.remove(ipParts.size() - 1);
        }
    }

    private static boolean isInValidIPPart(String ipPartStr) {
        int ipPrtInt = Integer.parseInt(ipPartStr);
        //Notice Validation
        return (ipPrtInt > 255 || (ipPartStr.startsWith("0") && ipPartStr.length() > 1));
    }

    private static class Pair implements Comparator<Pair> {
        int i, j;

        Pair(int a, int b) {
            i = a;
            j = b;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.i == o2.i) {
                if (o1.j == o2.j) return 0;
                else return o1.j - o2.j;
            } else return o1.i - o2.i;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return this.i == p.i && this.j == p.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.i, this.j);
        }
    }
}

