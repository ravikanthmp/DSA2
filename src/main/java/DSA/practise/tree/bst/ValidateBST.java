package DSA.practise.tree.bst;

import DSA.practise.tree.binaryTree.TreeNode;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if (root == null){
            return true;
        }else {
            boolean isLess = (max == null || root.val < max.val);
            boolean isGreater = (min == null || root.val > min.val);
            if (!isGreater || !isLess){
                return false;
            }else {
                return isValidBST(root.left, min, root) &&
                        isValidBST(root.right, root, max);
            }
        }

    }


}
