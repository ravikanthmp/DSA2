package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {

        ListNode fast = next(next(head));
        ListNode slow = head;
        while (fast != null){
            if (fast == slow){
                return true;
            }
            fast = next(next(fast));
            slow = next(slow);
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
