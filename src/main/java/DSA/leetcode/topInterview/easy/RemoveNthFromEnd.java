package DSA.leetcode.topInterview.easy;

import java.util.Objects;
import java.util.stream.Stream;

public class RemoveNthFromEnd {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    
    
    
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = (int) Stream.iterate(head, Objects::nonNull, curr -> curr.next).count();
        ListNode curr = head;
        if (n == size){
            return head.next;
        }else {
            for (int i = 0; i < size - n - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            return head;
        }

    }
    
}
