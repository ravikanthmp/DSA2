package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }else{
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
            return root;
        }
    }
}
