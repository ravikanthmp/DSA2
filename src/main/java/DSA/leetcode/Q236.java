package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }else {
            boolean thisOne = (root.val == p.val || root.val == q.val);

            TreeNode left = lowestCommonAncestor(root.left, p, q);

            TreeNode right = lowestCommonAncestor(root.right, p, q);


            if (left != null && right != null){
                return root;
            }else if (left != null){
                if (thisOne){
                    return root;
                }else {
                    return left;
                }
            }else if (right != null){
                if (thisOne){
                    return root;
                }else {
                    return right;
                }
            }else if (thisOne){
                return root;
            }
            return null;
        }
    }
}
