package DSA.leetcode;

public class Q1650 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        int pSize = size(p);
        int qSize = size(q);

        if (pSize > qSize){
            int diff = pSize - qSize;
            for (int i = 0; i < diff; i++) {
                p = p.parent;
            }
        }

        if (qSize > pSize){
            int diff = pSize - qSize;
            for (int i = 0; i < diff; i++) {
                q = q.parent;
            }
        }

        while (p != null && q != null){
            if (p == q){
                return p;
            }
            p = p.parent;
            q = q.parent;
        }
        return null;
    }

    private int size(Node root){
        int size = 0;
        for (Node curr = root; curr != null; curr = curr.parent){
            size++;
        }
        return size;
    }

}
