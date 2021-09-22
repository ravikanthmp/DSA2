package DSA.leetcode;


public class Q234 {

    public boolean isPalindrome(ListNode head) {

        ListNode beforeMid = beforeMid(head);

        beforeMid.next = reverse(beforeMid.next);

        boolean res = compare(head, beforeMid.next);

        beforeMid.next = reverse(beforeMid.next);

        return res;

    }

    private boolean compare(ListNode fh, ListNode sh) {
       ListNode c1 = fh;
       ListNode c2 = sh;
       while (c2 != null){
           if (c1.val != c2.val){
               return false;
           }
           c1 = c1.next;
           c2 = c2.next;
       }
       return true;
    }

    private ListNode reverse(ListNode head){
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode curr = head;
        while (curr != null){
            ListNode tmpNext = curr.next;
            curr.next = dummyHead.next;
            dummyHead.next = curr;
            curr = tmpNext;
        }
        return dummyHead.next;
    }

    private ListNode beforeMid(ListNode curr){
        if (curr == null){
            return null;
        }else {
            ListNode fast = curr;
            ListNode slow = fast;
            while (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
