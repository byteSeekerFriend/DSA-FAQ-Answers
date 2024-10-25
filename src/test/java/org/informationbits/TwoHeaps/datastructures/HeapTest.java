package org.informationbits.TwoHeaps.datastructures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HeapTest {
    final static int maxHeapSize = 10;
    Heap<Integer> heap;
    Logger logger = LogManager.getLogger();

    @BeforeEach
    void setUp() {
        heap = new Heap<Integer>(new Integer[]{1, 2, 3, 4, 5}, maxHeapSize, Comparator.naturalOrder());
        logger.info("Initialized TwoHeaps");
        heap.print();
        assertTrue(isEqual(heap.data, new Integer[]{5, 4, 3, 1, 2}));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        for (int i = 6; i <= 12; i++) {
            heap.insert(i);
            logger.info("TwoHeaps after inserting value: %d".formatted(i));
            heap.print();
        }
        assertTrue(isEqual(heap.data, new Integer[]{10, 9, 6, 7, 8, 3, 5, 1, 4, 2}));
    }

    @Test
    void peek() {
        logger.info("Present heap is -");
        heap.print();
        logger.info("Value present at the root of the TwoHeaps is: %d".formatted(heap.peek()));
    }

    @Test
    void pop() {
        while (heap.currentSize > 0) {
            heap.print();
            logger.info("Removed value %d present at the root of the heap".formatted(heap.pop()));
        }
        assertTrue(isEqual(heap.data, new Integer[]{}));
    }

    private boolean isEqual(Object[] a, Integer[] b) {
        for (int i = 0; i < b.length; i++) {
            if (((int) a[i]) != b[i]) return false;
        }
        return true;
    }
}