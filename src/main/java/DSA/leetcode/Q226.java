package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return null;
        }else {
            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);
            root.right = left;
            root.left = right;
            return root;
        }

    }

}
