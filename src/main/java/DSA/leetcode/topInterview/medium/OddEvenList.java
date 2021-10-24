package DSA.leetcode.topInterview.medium;

import DSA.leetcode.ListNode;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummyHead = new ListNode(0);
        ListNode evenDummyHead = new ListNode(0);

        ListNode oddCurr = oddDummyHead;
        ListNode evenCurr = evenDummyHead;
        int idx = 0;

        for (ListNode curr = head; curr != null; curr = curr.next, idx++){
            if (idx % 2 == 0){ // even
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
            }else {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
            }
        }
        oddCurr.next = null;

        evenCurr.next = oddDummyHead.next;
        return evenDummyHead.next;
    }

}
