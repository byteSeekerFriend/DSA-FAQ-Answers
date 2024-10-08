package org.informationbits.InPlaceLinkedListManipulation.solutionsuit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedList;
import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedList.isEqual;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReorderTest {
    Logger logger = LogManager.getLogger();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reorderList() {
        LinkedListNode h1 = Reorder.reorderList(new LinkedList(new int[]{1, 2, 3}).head);
        assertTrue(isEqual(h1, new LinkedList(new int[]{1, 3, 2}).head));

        LinkedListNode h2 = Reorder.reorderList(new LinkedList(new int[]{1, 3, 5, 6, 4, 2}).head);
        assertTrue(isEqual(h2, new LinkedList(new int[]{1, 2, 3, 4, 5, 6}).head));
    }
}