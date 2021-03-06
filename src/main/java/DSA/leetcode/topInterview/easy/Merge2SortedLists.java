package DSA.leetcode.topInterview.easy;

import DSA.leetcode.ListNode;

public class Merge2SortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (l1 != null && l2 != null){
            if (l1 == null){
                curr.next = l2;
                l2 = l2.next;
            }else if (l2 == null){
                curr.next = l1;
                l1 = l1.next;
            }else if (l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        return dummyHead.next;
    }

}
