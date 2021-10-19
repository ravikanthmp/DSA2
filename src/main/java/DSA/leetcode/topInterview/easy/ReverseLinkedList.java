package DSA.leetcode.topInterview.easy;

import DSA.leetcode.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = head;
        ListNode prev = dummyHead;
        while (curr != null){
            prev = curr;
            curr = curr.next;

            insertFirst(prev, dummyHead);
        }

        return dummyHead.next;
    }

    private void insertFirst(ListNode node, ListNode head){
        node.next = head.next;
        head.next = node;
    }
}
