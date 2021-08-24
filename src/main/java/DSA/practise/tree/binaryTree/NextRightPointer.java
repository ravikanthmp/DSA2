package DSA.practise.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
}

public class NextRightPointer {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            Node previous = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node removed = queue.remove();

                if (removed.left != null){
                    queue.add(removed.left);
                }
                if (removed.right != null){
                    queue.add(removed.right);
                }

                if (previous != null){
                    previous.next = removed;
                    previous = removed;
                }else {
                    previous = removed;
                }

            }
        }

        return root;
    }
}
