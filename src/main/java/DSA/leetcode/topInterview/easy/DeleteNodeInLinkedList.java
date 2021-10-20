package DSA.leetcode.topInterview.easy;

public class DeleteNodeInLinkedList {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public void deleteNode(ListNode node) {

        while (node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;

    }
}
