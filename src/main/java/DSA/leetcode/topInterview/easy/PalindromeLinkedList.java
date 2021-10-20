package DSA.leetcode.topInterview.easy;

import DSA.leetcode.ListNode;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Stream;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Stream.iterate(head, Objects::nonNull, node -> node.next)
                .forEach(stack::push);
        for (ListNode curr = head; curr != null; curr = curr.next){
            ListNode pop = stack.pop();
            if (curr.val != pop.val){
                return false;
            }
        }
        return true;
    }

}
