package DSA.leetcode;

import java.util.Stack;

public class Q234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }else if (head.next == null){
            return true;
        }

        Stack<ListNode> stack = new Stack<>();
        // push to stack
        for (ListNode curr = head; curr != null; curr = curr.next){
            stack.push(curr);
        }

        // compare
       ListNode curr = head;
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            if (pop.val != curr.val){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

}
