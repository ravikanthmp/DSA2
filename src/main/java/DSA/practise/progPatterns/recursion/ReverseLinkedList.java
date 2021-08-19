package DSA.practise.progPatterns.recursion;

public class ReverseLinkedList {

   
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }else {
            ListNode newTail = head;
            ListNode second = head.next;
            newTail.next = null;
            ListNode newHead = reverseList(second);
            second.next = newTail;
            return newHead;
        }
    }
    
}
