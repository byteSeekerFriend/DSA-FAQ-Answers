package org.informationbits.InPlaceLinkedListManipulation.datastructures;


//TODO: Make it generic.
public class LinkedList<T> {
    public LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(int[] lst) {
        if (lst == null || lst.length < 1) return;
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

    public static int size(LinkedListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static LinkedListNode clone(LinkedListNode head) {
        LinkedListNode newHead = null, newCurr = null, newPrev = null, curr = head;

        while (curr != null) {
            newCurr = new LinkedListNode(curr.data);
            if (newPrev != null) newPrev.next = newCurr;
            if (newHead == null) newHead = newCurr;
            newPrev = newCurr;
            curr = curr.next;
        }
        return newHead;
    }

    public static boolean isEqual(LinkedListNode headOne, LinkedListNode headTwo) {
        while (headOne != null && headTwo != null) {
            if (headOne.data != headTwo.data) return false;
            headOne = headOne.next;
            headTwo = headTwo.next;
        }
        return headOne == null && headTwo == null;
    }

    private void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
}