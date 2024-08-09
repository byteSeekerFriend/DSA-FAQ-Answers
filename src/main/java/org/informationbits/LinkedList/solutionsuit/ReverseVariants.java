package org.informationbits.LinkedList.solutionsuit;


import org.informationbits.LinkedList.datastructures.LinkedListNode;
import org.informationbits.LinkedList.util.LinkedListCreator;

public class ReverseVariants {

    public static LinkedListNode reverseV1(LinkedListNode head) {
        LinkedListNode prev = null, curr = head, next = head != null ? head.next : null;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            if (next == null) break;
            curr = next;
            next = curr.next;
        }
        return curr;
    }

    public static LinkedListNode reverseV2(LinkedListNode head) {
        LinkedListNode prev = null, curr = null, next = head;
        while (next != null) {
            curr = next;
            next = next.next;

            curr.next = prev;
            prev = curr;
        }
        return curr;
    }


    public static LinkedListNode reverseV3(LinkedListNode head) {
        if (head == null || head.next == null) return head;
        else {
            LinkedListNode newTail = head.next;
            head.next = null;
            LinkedListNode newHead = reverseV3(newTail);
            newTail.next = head;
            return newHead;
        }
    }

    public static LinkedListNode reverseV4(LinkedListNode head) {
        if (head == null) return head;

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode curr = head;
        LinkedListNode nxt = head.next;
        while (nxt != null) {
            curr.next = nxt.next;
            nxt.next = dummy.next;
            dummy.next = nxt;

            nxt = curr.next;
        }
        return dummy.next;
    }


    public static LinkedListNode reverseV5(LinkedListNode head, int start, int end) {
        if (start > end || end <= 0 || head == null || head.next == null) return head;

        LinkedListNode prtPrev = null, prtStart = null, prtEnd = null, prtNext = null;
        LinkedListNode curr = head, prev = null;

        int count = 1;
        while (curr != null) {
            if (start == count) {
                prtPrev = prev;
                prtStart = curr;
            }
            if (end == count) {
                prtEnd = curr;
                prtNext = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }

        if (prtStart == null) {
            if (start <= 0) prtStart = head;
            else return head;
        }

        if (prtPrev != null) prtPrev.next = null;
        if (prtEnd != null) prtEnd.next = null;

        LinkedListNode revPrtHead = reverseV1(prtStart);

        if (prtPrev != null) prtPrev.next = revPrtHead;
        prtStart.next = prtNext;

        return prtPrev == null ? revPrtHead : head;
    }

    //TODO: Simplify this function.
    public static LinkedListNode reverseV6(LinkedListNode head, int start, int end) {
        if (start > end || end <= 0 || head == null || head.next == null) return head;

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode prev = dummy, curr = head, next = curr.next;
        int nodeTraversed = 1;

        LinkedListNode nodeBeforeStart = start <= 0 ? dummy : null;
        while (curr != null) {
            if (nodeTraversed == start) {
                nodeBeforeStart = prev;
            }

            if (nodeTraversed > start && nodeTraversed <= end) {
                curr.next = prev;
            }

            if (nodeTraversed > end || next == null) {
                if (prev.next == curr && curr.next != prev) break;
                if (nodeBeforeStart != null) {
                    nodeBeforeStart.next.next = curr.next == prev ? next : curr;
                    nodeBeforeStart.next = curr.next == prev ? curr : prev;
                }
                break;
            }
            prev = curr;
            curr = next;
            next = curr.next;
            nodeTraversed++;
        }
        return dummy.next;
    }

    public static LinkedListNode reverseV7(LinkedListNode head, int start, int end) {
        if (start > end || end <= 0 || head == null || head.next == null) return head;

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode curr = head, prev = dummy;
        start--;
        end--;

        while (curr != null) {
            if (start <= 0) {
                break;
            }
            prev = curr;
            curr = curr.next;
            start--;
            end--;
        }

        LinkedListNode nodeBeforeGroup = start <= 0 ? prev : null;
        if (nodeBeforeGroup == null) return head;

        while (curr != null && curr.next != null) {
            if (end <= 0) {
                break;
            }
            LinkedListNode tmp = curr.next;

            curr.next = tmp.next;
            tmp.next = nodeBeforeGroup.next;
            nodeBeforeGroup.next = tmp;

            end--;
        }
        return dummy.next;
    }

    //TODO: Simplify this. 
    public static LinkedListNode reverseV8(LinkedListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;
        LinkedListNode curr = head, nodeBeforeGroup = null;
        int nodeCnt = 1;
        while (curr != null) {
            if (nodeCnt == k) {
                LinkedListNode nodeAfterGroup = curr.next;
                curr.next = null;

                LinkedListNode groupNewTail;
                if (nodeBeforeGroup == null) {
                    groupNewTail = head;
                } else {
                    groupNewTail = nodeBeforeGroup.next;
                    nodeBeforeGroup.next = null;
                }
                LinkedListNode groupNewHead = reverseV1(groupNewTail);
                if (nodeBeforeGroup == null) head = groupNewHead;
                else nodeBeforeGroup.next = groupNewHead;
                groupNewTail.next = nodeAfterGroup;

                nodeBeforeGroup = groupNewTail;
                curr = groupNewTail.next;
                nodeCnt = 1;
            } else {
                curr = curr.next;
                nodeCnt++;
            }
        }
        return head;
    }

    /**
    Note - There is difference in reverseV9 and reverseV8. If size of K is greater than the available elements
     (in the end or in total) then reverseV9 would still reverse those elements but reverseV8 would not.
    **/
    public static LinkedListNode reverseV9(LinkedListNode head, int k) {
        if (head == null || head.next == null || k <= 1) return head;

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode nodeBeforeGroup = dummy, curr = head, tmp;
        while (curr != null) {
            tmp = curr.next;
            for (int i = 1; i < k && tmp != null; i++) {
                curr.next = tmp.next;
                tmp.next = nodeBeforeGroup.next;
                nodeBeforeGroup.next = tmp;

                tmp = curr.next;
            }
            nodeBeforeGroup = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static LinkedListNode reverseV10(LinkedListNode head, int start, int end) {
        int len = LinkedListCreator.size(head);
        if (start<=0) start = 1;
        if (end >= len) end = len;

        if(head == null || head.next == null || start>=end || end<=0 || start>=len) return head;

        LinkedListNode[] posStart =  LinkedListCreator.find(head,start);
        LinkedListNode[] posEnd =  LinkedListCreator.find(head,end);

        LinkedListNode prevToGroup = posStart[0], groupStart = posStart[1], groupEnd = posEnd[1], nextToGroup = groupEnd.next;

        if (prevToGroup != null) prevToGroup.next = null;
        if (groupEnd != null) groupEnd.next = null;

        reverseV1(groupStart);

        if (prevToGroup != null) prevToGroup.next = groupEnd;
        groupStart.next = nextToGroup;

        return prevToGroup == null ? groupEnd:head;
    }
}