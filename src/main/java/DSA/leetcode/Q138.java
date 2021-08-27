package DSA.leetcode;

public class Q138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

       if (head == null){
           return null;
       }

        for (Node curr = head; curr != null;){
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }

        Node dummyHead = new Node(0);

        Node prev = dummyHead;
        for (Node curr = head; curr != null;){
            Node currRandom = curr.random;
            if (currRandom != null){
                Node copyRandom = currRandom.next;
                curr.next.random  = copyRandom;
            }
            Node next = curr.next.next;
            prev.next = curr.next;
            prev = prev.next;
            curr.next = next;
        }
        return dummyHead.next;
    }

}
