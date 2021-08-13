package DSA.leetcode;

import java.util.Arrays;
import java.util.Comparator;

import java.util.PriorityQueue;

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
        Comparator<ListNode> nodeComparator = Comparator.comparingInt(l -> l.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(nodeComparator);

        // init
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // keep removing
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (!pq.isEmpty()){
            ListNode min = pq.remove();
            curr.next = min;
            curr = curr.next;

            if (min.next != null){
                pq.add(min.next);
            }
        }

        return dummy.next;
    }


}
