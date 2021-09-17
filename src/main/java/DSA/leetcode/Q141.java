package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q141 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = fast;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    private ListNode next(ListNode node){
        if (node == null){
            return null;
        }else {
            return node.next;
        }
    }
}
