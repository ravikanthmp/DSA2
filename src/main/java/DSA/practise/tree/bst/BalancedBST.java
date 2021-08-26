package DSA.practise.tree.bst;

public class BalancedBST {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }else {
            if (isBalanced(root.left) && isBalanced(root.right)){
                return Math.abs(height(root.left) - height(root.right)) <= 1;
            }else {
                return false;
            }
        }
    }

    private int height(TreeNode node){
        if (node == null){
            return -1;
        }else if (isLeaf(node)){
            return 0;
        }else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
