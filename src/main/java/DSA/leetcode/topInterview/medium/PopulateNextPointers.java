package DSA.leetcode.topInterview.medium;

public class PopulateNextPointers {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node levelHead = root;
        while (levelHead != null){

            Node sibling = null;
            for (Node curr = levelHead; curr != null; curr = curr.next){

                // conn1
                if (curr.left != null){
                    curr.left.next = curr.right;
                }

                // conn2
                Node child = curr.left != null ? curr.left : curr.right;
                if (sibling != null && child != null){
                    sibling.next = child;
                }
                sibling = child;
            }

            levelHead = levelHead.left;
        }
        return root;
    }

}
