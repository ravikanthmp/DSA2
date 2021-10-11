package DSA.leetcode;

public class Q21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        while (l1 != null || l2 != null){
            if (l1 == null){
                prev.next = l2;
                l2 = l2.next;
            }else if (l2 == null){
                prev.next = l1;
                l1 = l1.next;
            }else if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
