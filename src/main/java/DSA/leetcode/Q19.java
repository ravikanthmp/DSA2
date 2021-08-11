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
        int N = length(head);

        if (Objects.isNull(head)){
            return null;
        }

        if (n == N){
            // remove head;
            head = head.next;
            return head;
        }

        int x = N - n - 1;
        ListNode curr = head;
        for (int i = 0; i < x; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    private int length(ListNode node){
        return (int) Stream.iterate(node, Objects::nonNull, curr -> curr.next).count();
    }

    public static void main(String[] args) {

    }
}
