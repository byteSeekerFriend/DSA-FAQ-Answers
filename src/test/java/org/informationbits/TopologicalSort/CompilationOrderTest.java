package org.informationbits.TopologicalSort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CompilationOrderTest {

    @Test
    void getPossibleCompilationOrder() {
        ArrayList<ArrayList<Character>> dependencies = new ArrayList<ArrayList<Character>>();
        for (Character[] edge : new Character[][]{{'C', 'A'}, {'B', 'A'}, {'D', 'C'}, {'E', 'B'}, {'E', 'D'}}) {
            ArrayList<Character> e = new ArrayList<Character>();
            e.add(edge[0]);
            e.add(edge[1]);
            dependencies.add(e);
        }
        CompilationOrder.getPossibleCompilationOrder(dependencies);
    }
}