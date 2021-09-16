package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q124 {

    int maxSoFar = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int x = maxPathSum(root.left);
            int y = maxPathSum(root.right);
            maxSoFar = Math.max(maxSoFar, x + y + root.val);
            return Math.max(0,  root.val + Math.max(x, y));
        }
    }

}
