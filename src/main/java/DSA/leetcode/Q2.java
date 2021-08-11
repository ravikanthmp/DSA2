package DSA.leetcode;

import java.util.Objects;

public class Q2 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode dummyHead = prev;
        int carry = 0;
        while (l1 != null || l2 != null){
            int sum = getVal(l1) + getVal(l2) + carry;
            carry = sum / 10;
            sum = sum % 10;
            prev.next = new ListNode(sum);
            prev = prev.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        // check carry for last node
        if (carry != 0){
            prev.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    private int getVal(ListNode x) {
        return Objects.nonNull(x) ? x.val : 0;
    }

}
