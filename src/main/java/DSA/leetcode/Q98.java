package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q98 {

    public boolean isValidBST(TreeNode root) {

        if (root == null){
            return true;
        }else {
            return isValid(root, null, null);
        }
    }

    private boolean isValid(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null){
            return true;
        }else {
            boolean greater = (minValue == null || (root.val > minValue));
            boolean less = ((maxValue == null) || (root.val < maxValue) );
            if (greater & less){
                return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
            }else {
                return false;
            }
        }
    }

}
