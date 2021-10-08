package DSA.leetcode;

public class Q143 {

    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = fast;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalfHead = slow.next;

        secondHalfHead = reverse(secondHalfHead);

        slow.next = null;


        merge(dummyHead.next, secondHalfHead);
    }

    private ListNode merge(ListNode first, ListNode second){
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        boolean firstTurn = true;
        while (first != null || second != null){
            if (first == null){
                prev.next = second;
                second = second.next;
            }else if (second == null){
                prev.next = first;
                first = first.next;
            }else if (firstTurn){
                prev.next = first;
                first = first.next;
                firstTurn = false;
            }else {
                prev.next = second;
                second = second.next;
                firstTurn = true;
            }

            prev = prev.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head){

        if (head == null || head.next == null){
            return head;
        }else {
            ListNode newTail = head.next;
            ListNode reverse = reverse(head.next);
            head.next = null;
            newTail.next = head;
            return reverse;
        }
    }

}
