package DSA.leetcode.topInterview.easy;

import DSA.practise.tree.binaryTree.TreeNode;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null){
            return true;
        }else {
            boolean lt = (max == null || root.val < max);
            boolean gt = (min == null || root.val > min);
            if (lt && gt){
                return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
            }else {
                return false;
            }
        }
    }

}
