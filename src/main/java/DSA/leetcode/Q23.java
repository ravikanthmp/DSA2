package DSA.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;

        PriorityQueue<ListNode> minPQ = new PriorityQueue<>(Comparator.comparingInt(ln -> ln.val));
        for (ListNode list : lists) {
            if (list != null){
                minPQ.add(list);
            }

        }

        while (!minPQ.isEmpty()){
            ListNode remove = minPQ.remove();
            prev.next = remove;
            prev = prev.next;
            if (remove.next != null){
                minPQ.add(remove.next);
            }
        }
        return dummyHead.next;
    }
}
