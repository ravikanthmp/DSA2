package DSA.practise.tree.bst;

import DSA.practise.tree.binaryTree.TreeNode;

public class BSTDelete {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null){
            return null;
        }else {

            if (key == root.val){

                // case 1 . leaf
                if (isLeaf(root)){
                    return null;
                }else if (root.left != null && root.right != null){
                    TreeNode min = min(root.right);
                    root.val = min.val;
                    root.right = delMin(root.right);
                    return root;
                }else if (root.left != null){
                    return root.left;
                }else {
                    return root.right;
                }
            }else if (key < root.val){
                root.left = deleteNode(root.left, key);
                return root;
            }else {
                root.right = deleteNode(root.right, key);
                return root;
            }
        }
    }

    private TreeNode min(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode curr = node;
        while (curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

    private TreeNode delMin(TreeNode root){
        if (root == null){
            return null;
        }else {
            if (root.left == null){
                return root.right;
            }else {
                root.left = delMin(root.left);
                return root;
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        BSTDelete bst = new BSTDelete();
        bst.deleteNode(root, 3);
    }

}
