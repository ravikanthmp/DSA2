package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q1644 {

    class CountHolder{
        int count = 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        CountHolder countHolder = new CountHolder();
        TreeNode treeNode = lcaHelper(root, p, q, countHolder);
        return countHolder.count == 2 ? treeNode : null;
    }

    private TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q, CountHolder helper){
        if (root == null){
            return null;
        }else {
            boolean thisOne = (root.val == p.val || root.val == q.val);
            if (thisOne){
                helper.count++;
            }
            TreeNode left = lcaHelper(root.left, p, q, helper);
            TreeNode right = lcaHelper(root.right, p, q, helper);

            if (left != null && right != null){
                return root;
            }else if (left != null){
               return thisOne ? root : left;
            }else if (right != null){
                return thisOne ? root : right;
            }else if (thisOne){
                return root;
            }else {
                return null;
            }
        }
    }

}
