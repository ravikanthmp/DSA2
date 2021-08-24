package DSA.practise.tree.binaryTree;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }else {
            boolean thisOne = (root.val == p.val) || (root.val == q.val);
            TreeNode left = lca(root.left, p, q);
            TreeNode right = lca(root.right, p, q);
            if (left != null && right != null){
                return root;
            }else if (left != null && thisOne){
                return root;
            }else if (right != null && thisOne){
                return root;
            }else if (left != null){
                return left;
            }else if (right != null){
                return right;
            }else {
                return null;
            }
        }
    }

}
