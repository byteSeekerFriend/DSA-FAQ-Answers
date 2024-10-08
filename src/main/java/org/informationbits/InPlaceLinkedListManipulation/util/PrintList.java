package org.informationbits.InPlaceLinkedListManipulation.util;


import org.apache.logging.log4j.Logger;
import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;

//TODO: Remove System.out.print via logger. 
public class PrintList<T> {
    public static void print(LinkedListNode head, Logger logger) {
        System.out.print("InPlaceLinkedListManipulation data: ");
        if (head == null) System.out.print("empty");
        LinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}