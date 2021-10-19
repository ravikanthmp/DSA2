package DSA.leetcode.topInterview.easy;

public class RemoveNthFromEnd {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int gap = 0;
        while (gap < n){
            fast = fast.next;
            gap++;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        RemoveNthFromEnd test = new RemoveNthFromEnd();
        System.out.println(test.removeNthFromEnd(head, 1));
    }

}
