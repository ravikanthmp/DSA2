package DSA.leetcode;

import java.util.Objects;
import java.util.stream.Stream;

public class Q19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {


        if (Objects.isNull(head)){
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = head;
        int gap = 0;
        for(ptr2 = head; ptr2.next != null && gap != n; ptr2 = ptr2.next){
            gap++;
        }

        if (gap < n){
            head = head.next;
            return head;
        }

        while (next(ptr2) != null){
            ptr2 = next(ptr2);
            ptr1 = next(ptr1);
        }
        ptr1.next = next(ptr1.next);
        return head;


    }

    private ListNode next(ListNode node){
        return Objects.isNull(node) ? null : node.next;
    }

    private int length(ListNode node){
        return (int) Stream.iterate(node, Objects::nonNull, curr -> curr.next).count();
    }

    public static void main(String[] args) {

    }
}
