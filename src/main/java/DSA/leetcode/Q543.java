package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.Map;

public class Q543 {

    private int maxSoFar = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        test(root);
        return maxSoFar;
    }

    private boolean isLeaf(TreeNode root){
        return root != null && (root.left == null) && (root.right == null);
    }

    private int test(TreeNode root) {
        if (root != null){
            if (isLeaf(root)){
                return 0;
            }else {
                int left = test((root.left));

                int right = test((root.right));


                int leftPath = root.left != null ? left + 1 : 0;
                int rightPath = root.right!= null ? right + 1 : 0;
                maxSoFar = Math.max(maxSoFar, leftPath + rightPath);
                return Math.max(left + 1, right + 1);
            }

        }else {
            return 0;
        }
    }

}
