package DSA.practise.tree;

public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null || isLeaf(root))  {
            return true;
        }else {
           return isSymmetric(root.left, root.right);
        }
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else if (left.val != right.val){
            return false;
        }else {
            return isSymmetric(left.left, right.right) &&
                    isSymmetric(left.right, right.left);
        }
    }

    private boolean isLeaf(TreeNode node){
        return node != null && (node.left == null && node.right == null);
    }
    
}
