package DSA.leetcode;

public class Q141 {

    public boolean hasCycle(ListNode head) {
       ListNode fast = head;
       ListNode slow = fast;
       while (next(fast) != null && next(next(fast)) != null){
            fast = next(next(fast));
            slow = next(slow);
            if (fast == slow){
                return true;
            }
        }
       return false;
    }

    private ListNode next(ListNode node) {
       if (node.next != null){
           return node.next;
       }else {
           return null;
       }
    }


}
