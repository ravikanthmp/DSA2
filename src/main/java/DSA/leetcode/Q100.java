package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( (p == null) && (q == null) ){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val == q.val){
            return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
        }else {
            return false;
        }
    }

}
