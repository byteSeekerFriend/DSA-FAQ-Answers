package org.informationbits.TopologicalSort;

import java.util.*;

/**
 * Input -
 * Second part is source and first is destination like A -> C, A -> B
 * dependencies - [C, A] [B, A] [D, C] [E, B] [E, D]
 * <p>
 * Output - (Any One - Because all are possible)
 * A, B, C, D, E
 * A, C, B, D, E
 * A, C, D, B, E
 */
public class CompilationOrder {

    private static Map<Character, Node> constructGraph(ArrayList<ArrayList<Character>> dependencies) {
        Map<Character, Node> graph = new HashMap<Character, Node>();
        for (List<Character> edge : dependencies) {
            Character srcName = edge.get(1);
            Character destName = edge.get(0);
            Node srcNode = graph.getOrDefault(srcName, new Node(srcName));
            Node destNode = graph.getOrDefault(destName, new Node(destName));
            srcNode.out.add(destName);
            destNode.in.add(srcName);
            graph.put(srcName, srcNode);
            graph.put(destName, destNode);
        }
        return graph;
    }

    private static LinkedList<Character> getRootNodeNames(Map<Character, Node> graph) {
        //In case of disconnected graph.
        LinkedList<Character> roots = new LinkedList<Character>();
        for (Map.Entry<Character, Node> nodeEntry : graph.entrySet()) {
            if (nodeEntry.getValue().in.size() == 0) roots.add(nodeEntry.getKey());
        }
        return roots;
    }

    public static List<Character> getPossibleCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        ArrayList<Character> possibleOrder = new ArrayList<Character>();
        Map<Character, Node> graph = constructGraph(dependencies);
        LinkedList<Character> currRootNodes = getRootNodeNames(graph);
        if (currRootNodes.size() == 0) return possibleOrder;

        for (int i = 0; i < graph.size() && !currRootNodes.isEmpty(); i++) {
            Character nodeName = currRootNodes.remove(0);
            possibleOrder.add(nodeName);
            for (Character neighbourNodeName : graph.get(nodeName).out) {
                Node n = graph.get(neighbourNodeName);
                n.in.remove(nodeName);
                if (n.in.size() == 0) currRootNodes.add(n.name);
            }
        }

        return possibleOrder.size() == graph.size() ? possibleOrder : new ArrayList<Character>();
    }

    static class Node {
        Character name;
        Set<Character> in, out;

        Node(Character n) {
            name = n;
            in = new HashSet<Character>();
            out = new HashSet<Character>();
        }
    }
}
