package DSA.practise.tree.binaryTree;

// TODO: 8/22/21
public class Unival {


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
    
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int rootVal = root.val;
            return check(root.left, rootVal) + check(root.right, rootVal);
        }
    }

    private int check(TreeNode node, int rootVal) {
        if (node == null){
            return 0;
        }else {
            int val = node.val == rootVal ? 1 : 0;
            return val + check(node.left, rootVal) + check(node.right, rootVal);
        }
    }

}
