package DSA.leetcode.topInterview.medium;

import DSA.leetcode.ListNode;

public class Add2Numbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int colSum = 0;
            if (l1 == null) {
                colSum = carry + l2.val;
            } else if (l2 == null) {
                colSum = carry + l1.val;
            } else {
                colSum = carry + l1.val + l2.val;
            }

            carry = colSum / 10;
            colSum = colSum % 10;

            prev.next = new ListNode(colSum);

            prev = next(prev);
            l1 = next(l1);
            l2 = next(l2);
        }

        if (carry != 0){
            prev.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    private ListNode next(ListNode node) {
        return node == null ? null : node.next;
    }

}
