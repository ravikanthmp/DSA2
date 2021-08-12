package DSA.leetcode;

import java.util.Objects;

public class Q23 {

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
    
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
        if (lo > hi){
            return null;
        }
        if (lo == hi){
            return lists[lo];
        }
        if (hi == lo + 1){
            return merge2Lists(lists[lo], lists[hi]);
        }
        int mid = lo + (hi - lo)/2;
        ListNode listNode1 = mergeKLists(lists, lo, mid);
        ListNode listNode2 = mergeKLists(lists, mid + 1, hi);
        return merge2Lists(listNode1, listNode2);
    }


    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null || l2 != null){
            if (l1 == null){
                curr.next = l2;
                l2 = l2.next;
            }else if (l2 == null){
                curr.next = l1;
                l1 = l1.next;
            }else {
                int cmp = Integer.compare(l1.val, l2.val);
                if (cmp <= 0){
                    curr.next = l1;
                    l1 = l1.next;
                }else {
                    curr.next = l2;
                    l2 = l2.next;
                }
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}
