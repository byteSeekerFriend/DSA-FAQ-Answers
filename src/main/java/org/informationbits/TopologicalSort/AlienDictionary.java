package org.informationbits.TopologicalSort;

import java.util.*;


/**
 * https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
 * https://www.geeksforgeeks.org/problems/alien-dictionary/1
 * https://algo.monster/liteproblems/269
 */
public class AlienDictionary {
    public static String getAlienOrder(List<String> words) {
        if (words == null) return "";

        Map<Character, Node> graph = constructGraph(words);
        if (graph == null) return "";
        List<Character> currRootNodes = getRootNodeNames(graph);

        StringBuffer possibleOrder = new StringBuffer();

        for (int i = 0; i < graph.size() && !currRootNodes.isEmpty(); i++) {
            Character nodeName = currRootNodes.remove(0);
            possibleOrder.append(nodeName);
            for (Character neighbourNodeName : graph.get(nodeName).out) {
                Node n = graph.get(neighbourNodeName);
                n.in.remove(nodeName);
                if (n.in.size() == 0) currRootNodes.add(n.name);
            }
        }
        return possibleOrder.length() == graph.size() ? possibleOrder.toString() : "";
    }

    private static LinkedList<Character> getRootNodeNames(Map<Character, Node> graph) {
        //In case of disconnected graph.
        LinkedList<Character> roots = new LinkedList<Character>();
        for (Map.Entry<Character, Node> nodeEntry : graph.entrySet()) {
            if (nodeEntry.getValue().in.size() == 0) roots.add(nodeEntry.getKey());
        }
        return roots;
    }

    private static Map<Character, Node> constructGraph(List<String> words) {
        Map<Character, Node> graph = new HashMap<Character, Node>();
        for (char c : getDistinctChar(words)) {
            graph.put(c, new Node(c));
        }

        for (int i = 1; i < words.size(); i++) {
            char[] edge = getEdge(words.get(i - 1), words.get(i));
            if (edge == null) return null;
            if (edge.length == 0) continue;
            Node src = graph.get(edge[0]), dest = graph.get(edge[1]);
            src.out.add(dest.name);
            dest.in.add(src.name);
        }
        return graph;
    }

    private static Set<Character> getDistinctChar(List<String> words) {
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                charSet.add(c);
            }
        }
        return charSet;
    }

    private static char[] getEdge(String srcStr, String destStr) {
        if (srcStr.startsWith(destStr))
            return null;
        if (destStr.startsWith(srcStr)) return new char[]{};

        int len = Math.min(srcStr.length(), destStr.length());
        for (int i = 0; i < len; i++) {
            if (srcStr.charAt(i) == destStr.charAt(i)) continue;
            return new char[]{srcStr.charAt(i), destStr.charAt(i)};
        }

        return null;
    }

    static class Node {
        Character name;
        Set<Character> in;
        Set<Character> out;

        Node(Character c) {
            name = c;
            in = new HashSet<Character>();
            out = new HashSet<Character>();
        }
    }
}

