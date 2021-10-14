package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        boolean check = check(root, subRoot);
        if (check){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null){
            return true;
        }else if (root == null || subRoot == null){
            return false;
        }else if (root.val != subRoot.val){
            return false;
        }else {
            return check(root.left, subRoot.left) && check(root.right, subRoot.right);
        }
    }
}
