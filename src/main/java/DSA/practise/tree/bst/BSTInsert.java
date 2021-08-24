package DSA.practise.tree.bst;

import DSA.practise.tree.binaryTree.TreeNode;

public class BSTInsert {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = insert(root, val);
        return root;
    }

    TreeNode insert(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }else {

            if (val < root.val){
                root.left = insertIntoBST(root.left, val);
            }else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;

        }
    }
}
