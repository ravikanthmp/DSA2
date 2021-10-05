package DSA.leetcode;

import java.util.*;

public class Q133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Integer, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
       return cloneInternal(node, node);
    }

    private Node cloneInternal(Node node, Node parent) {
        if (cloned.containsKey(node.val)){
            return cloned.get(node.val);
        }else {
            Node clonedNode = new Node(node.val);

            for (Node origNeighbour : node.neighbors) {
                if (origNeighbour.val != parent.val){
                    clonedNode.neighbors.add(cloneInternal(origNeighbour, clonedNode));
                }

            }

            return clonedNode;
        }


    }

}
