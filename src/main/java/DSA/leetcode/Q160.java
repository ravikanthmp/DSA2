package DSA.leetcode;

public class Q160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);
        if (l1 == 0 && l2 == 0){
            return null;
        }else {
            ListNode c1 = headA;
            ListNode c2 = headB;
            if (l1 >= l2){
                for (int i = 0; i < (l1 - l2); i++) {
                    c1 = c1.next;
                }
            }else {
                for (int i = 0; i < (l2 - l1); i++) {
                    c2 = c2.next;
                }
            }
            while (c1 != null && c2 != null){
                if (c1.next == c2.next){
                    return c1.next;
                }else {
                    c1 = c1.next;
                    c2 = c2.next;
                }
            }
            return null;
        }
    }

    private int length(ListNode head){
        int count = 0;
        for (ListNode curr = head; curr != null; curr = curr.next){
            count++;
        }
        return count;
    }

}
