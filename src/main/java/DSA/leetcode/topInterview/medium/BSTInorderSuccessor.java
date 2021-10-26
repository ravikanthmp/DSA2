package DSA.leetcode.topInterview.medium;

import DSA.practise.tree.binaryTree.TreeNode;

public class BSTInorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if (p.right != null){
            res = p.right;
            while (res.left != null){
                res = res.left;
            }
        }
        if (res != null){
            return res;
        }else {

            TreeNode curr = root;
            while (curr != null){
                if (curr.val > p.val){
                    res = curr;
                    curr = curr.left;
                }else {
                    curr = curr.right;
                }
            }
            return res;
        }
    }
}
