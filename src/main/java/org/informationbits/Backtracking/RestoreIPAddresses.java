package org.informationbits.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 */
public class RestoreIPAddresses {
    public static List<String> getIpAddresses(String s) {
        List<String> ips = new ArrayList<String>();
        List<String> ipParts = new ArrayList<String>();
        dfsIPFinder(s, 0, ipParts, ips);
        return ips;
    }

    private static void dfsIPFinder(String digits, int digitsIndex, List<String> ipParts, List<String> solutions) {
        if (ipParts.size() == 4) {
            if (digitsIndex == digits.length()) solutions.add(String.join(".", ipParts));
            return;
        }
        //Notice loop conditions
        for (int i = digitsIndex; i <= Math.min(digitsIndex + 2, digits.length() - 1); i++) {
            String ipPart = digits.substring(digitsIndex, i + 1);
            if (isInValidIPPart(ipPart)) return;

            ipParts.add(ipPart);
            dfsIPFinder(digits, i + 1, ipParts, solutions);
            ipParts.remove(ipParts.size() - 1);
        }
    }

    private static boolean isInValidIPPart(String ipPartStr) {
        int ipPrtInt = Integer.parseInt(ipPartStr);
        //Notice Validation
        return (ipPrtInt > 255 || (ipPartStr.startsWith("0") && ipPartStr.length() > 1));
    }
}

