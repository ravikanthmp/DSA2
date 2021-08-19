package DSA.practise.progPatterns.recursion;

public class BinaryTreeSearch {

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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }else {
            if (root.val == val){
                return root;
            }else {
                TreeNode left = searchBST(root.left, val);
                if (left == null){
                    return searchBST(root.right, val);
                }else {
                    return left;
                }
            }
        }
    }


}