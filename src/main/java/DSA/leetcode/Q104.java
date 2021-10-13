package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q104 {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

}
