package DSA.leetcode;

import java.util.Objects;

public class Q21 {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode curr = newHead;
        ListNode nextNode;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            if (Objects.isNull(l1)) {
                nextNode = l2;
                l2 = l2.next;
            } else if (Objects.isNull(l2)) {
                nextNode = l1;
                l1 = l1.next;
            } else {
                int cmp = Integer.compare(l1.val, l2.val);
                if (cmp <= 0) {
                    nextNode = l1;
                    l1 = l1.next;
                } else {
                    nextNode = l2;
                    l2 = l2.next;
                }
            }
            curr.next = nextNode;
            curr = curr.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
