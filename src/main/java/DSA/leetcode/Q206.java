package DSA.leetcode;

public class Q206 {

    public ListNode reverseList(ListNode head) {
      if (head == null){
          return null;
      }else {
          ListNode nextHead = head.next;
          head.next = null;
          ListNode newHead = reverseList(nextHead);
          nextHead.next = head;
          return newHead;
      }
    }

    public static void main(String[] args) {

    }

}
