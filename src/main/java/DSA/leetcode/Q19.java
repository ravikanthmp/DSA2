package DSA.leetcode;

import java.util.Objects;
import java.util.stream.Stream;

public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = null;
        ListNode slow = null;
        for (int i = 0; i < n; i++) {
            if (fast == null){
                fast = head;
            }else {
                fast = fast.next;
            }

        }

        while (fast.next != null){
            fast = fast.next;
            if (slow == null){
                slow = head;
            }else {
                slow = slow.next;
            }
        }

        if (slow != null){
            slow.next = slow.next.next;
            return head;
        }else {
            return head.next;
        }

    }

//    private ListNode next(ListNode node){
//        return Objects.isNull(node) ? null : node.next;
//    }
//
//    private int length(ListNode node){
//        return (int) Stream.iterate(node, Objects::nonNull, curr -> curr.next).count();
//    }

    public static void main(String[] args) {

    }
}
