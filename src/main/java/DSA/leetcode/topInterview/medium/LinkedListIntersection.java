package DSA.leetcode.topInterview.medium;

import DSA.leetcode.ListNode;

import java.util.Objects;
import java.util.stream.Stream;

public class LinkedListIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        ListNode faster = (lenA >= lenB) ? headA : headB;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            faster = faster.next;
        }

        ListNode slower = (headA == faster) ? headB : headA;

        while (faster != null || slower != null){
            if (faster == slower){
                return faster;
            }else {
                faster = faster.next;
                slower = slower.next;
            }
        }
        return null;
    }

    private int length(ListNode head) {
        return (int) Stream
                .iterate(head, Objects::nonNull, node -> node.next)
                .count();
    }

}
