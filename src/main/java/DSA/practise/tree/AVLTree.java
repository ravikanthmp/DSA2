package DSA.practise.tree;

import java.util.*;


public class AVLTree<T extends Comparable<T>> extends BST<T> {

    class Node{
       T data;
       Node left;
       Node right;
       int height;
       int copies;

        public Node(T data) {
            this.data = data;
            this.copies = 1;

        }
    }

    Node root;

    private int height(Node node){
        if (Objects.isNull(node)){
            return 0;
        }else {
            return node.height;
        }
    }

    private Node rotateRight(Node root){
        if (root == null){
            return null;
        }
        Node C = root.left;
        Node L = root.right;
        Node temp = C.right;

        root.left = temp;
        C.right = root;
        return C;

    }

    private Node rotateLeft(Node root){
        if (root == null){
            return null;
        }
        Node A = root;
        Node C = root.right;
        Node K = C != null ? C.left : null;

        C.left = A;
        A.right = K;

        return C;
    }

    public int size(Node node){
        if (Objects.isNull(node)){
            return 0;
        }else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    public void add(T data){
        root = add(root, data);
    }

    private Node add(Node root, T data){
        if (root == null){
            return new Node(data);
        }else {
            int cmp = data.compareTo(root.data);
            if (cmp == 0){
                root.copies++;
            }else if (cmp < 0){
                root.left = add(root.left, data);
            }else {
                root.right = add(root.right, data);
            }
            return rotate(root);
        }
    }

    private Node rotate(Node root) {
        updateHeight(root);
        if (root == null){
            return root;
        }else if (isRightHeavy(root)){
            boolean isBLeftHeavy = isLeftHeavy(root.right);
            if (isBLeftHeavy){
                // case 1
                root.right = rotateRight(root.right);
            }
            root = rotateLeft(root);

        }else if (isLeftHeavy(root)){
            boolean isBRightHeavy = isRightHeavy(root.left);
            if (isBRightHeavy){
                root.left = rotateLeft(root.left);
            }
            root = rotateRight(root);

        }

        if (root == null){
            System.out.println("ckdsbkc");
        }
        return root;
    }

    private void updateHeight(Node root){
        if (!Objects.isNull(root)){
            root.height = 1 + Math.max(height(root.left), height(root.right));
        }
    }

    public int height(){
        return height(root);
    }

    private boolean isLeftHeavy(Node root){
        if (root == null){
            return false;
        }else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            boolean isRotateNeeded = Math.abs(rightHeight - leftHeight) > 1;
            if (!isRotateNeeded){
                return false;
            }else {
                return leftHeight > rightHeight;
            }
        }
    }

    private boolean isRightHeavy(Node root){
        if (root == null){
            return false;
        }else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            boolean isRotateNeeded = Math.abs(rightHeight - leftHeight) > 1;
            if (!isRotateNeeded){
                return false;
            }else {
                return rightHeight > leftHeight;
            }
        }
    }

    public boolean contains(T item){
        return false;
    }

    public Iterable<T> inOrder(){
        List<T> list = new ArrayList<>();
        inOrder(root, list);
        return list;
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
    public int hashCode() {
        return Objects.hash(root);
    }

    public static void main(String[] args) {
        int[] arr = new int[20000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * arr.length);
        }


        System.out.println(Arrays.toString(arr));

        AVLTree<Integer> tree = new AVLTree<>();
        Arrays.stream(arr).forEach(data -> {
            tree.add(data);
        });
        System.out.println(tree);
    }
}
