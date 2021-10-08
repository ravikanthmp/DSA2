package DSA.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(0);
        if(lists == null || lists.length == 0){
            return dummyHead.next;
        }
        ListNode prev = dummyHead;

        PriorityQueue<ListNode> minPQ = new PriorityQueue<>(Comparator.comparingInt(ln -> ln.val));
        for (ListNode list : lists) {
            minPQ.add(list);
        }

        while (!minPQ.isEmpty()){
            ListNode lowest = minPQ.remove();
            prev.next = lowest;
            if (lowest.next != null){
                minPQ.add(lowest.next);
            }
            prev = prev.next;
        }

        return dummyHead.next;
    }

}
