package DSA.practise.tree;

import java.util.*;

public class BST<T extends Comparable<T>>  {


    class Node {
        T data;
        Node left;
        Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public boolean contains(T data) {
        return contains(root, data);
    }

    public void add(T data) {
        root = add(root, data);
    }

    public void remove(T data) {
        root = remove(root, data);
    }

    public Iterable<T> inOrder(){
        List<T> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private Node remove(Node root, T data) {
        if (root == null){
            return null;
        }
        int cmp = data.compareTo(root.data);
        if (cmp < 0){
            root.left = remove(root.left, data);
        }else if (cmp > 0){
            root.right = remove(root.right, data);
        }else {
            // Case 1. Both leaf node
            if (Objects.isNull(root.left) && Objects.isNull(root.right)){
                return null;
            }

            // Case 2 : Left child is null..
            if (Objects.isNull(root.left)){
                return root.right;
            }

            // Case 3 : Right child is null
            if (Objects.isNull(root.right)){
                return root.left;
            }

            //Case 4 : has both children
            // Either select max(left) or min(right) as successor
            int random = (int) (Math.random()*10);
            if (random < 5){
                Node maxLeft = max(root.left);
                T temp = root.data;
                root.data = maxLeft.data;
                maxLeft.data = temp;
                root.left = remove(root.left, temp);
            }else {
                Node minRight = min(root.right);
                T temp = root.data;
                root.data = minRight.data;
                minRight.data = temp;
                root.right = remove(root.right, temp);
            }
        }
        return root;
    }

    private Node max(Node root){
        Node curr = root;
        while (curr.right != null){
             curr = curr.right;
        }
        return curr;
    }

    private Node min(Node root){
        Node curr = root;
        while (curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    private Node add(Node root, T data) {
        if (root == null) {
            return new Node(data, null, null);
        }
        int cmp = data.compareTo(root.data);
        if (data == root.data) {
            return root;
        } else if (cmp < 0) {
            root.left = add(root.left, data);
            return root;
        } else {
            root.right = add(root.right, data);
            return root;
        }
    }


    private void inOrder(Node root, List<T> list) {

        if (root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    @Override
    public String toString() {
        return "BST{" +
                "nodes=" + inOrder() +
                '}';
    }

    public boolean isEmpty(){
        return root == null;
    }

    private boolean contains(Node root, T data) {
        if (root == null) {
            return false;
        }

        int cmp = data.compareTo(root.data);

        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return contains(root.left, data);
        } else {
            return contains(root.right, data);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

//        arr = new int[]{23, 38, 39, 41, 42, 46, 48, 57, 63, 7};

        BST<Integer> bst = new BST<>();
        Arrays.stream(arr).forEach(bst::add);
        System.out.println(bst);

        while (!bst.isEmpty()){
            int x = (int)(Math.random() * 100);
            if (bst.contains(x)){
                System.out.println("BST contains " + x);
                bst.remove(x);
            }else {
                System.out.println("BST does not contain " + x);
            }
            System.out.println(bst);
        }
    }
}
