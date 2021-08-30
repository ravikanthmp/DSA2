package DSA.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class ListNodeWrapper{
        ListNode node;

    }

    public boolean hasCycle(ListNode head) {

        Set<ListNode> visited = new HashSet<>();
        for(ListNode curr = head; curr != null; curr = curr.next){
            if (visited.contains(curr)){
                return true;
            }else {
                visited.add(curr);
            }
        }
        return false;
    }

}
