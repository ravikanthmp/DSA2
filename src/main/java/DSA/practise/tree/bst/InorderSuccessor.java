package DSA.practise.tree.bst;

import DSA.practise.tree.binaryTree.TreeNode;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null){
            return null;
        }

        TreeNode res = null;
        TreeNode curr = root;
        while (curr != null){
            int cmp = Integer.compare(curr.val, p.val);
            if (cmp == 0){
                break;
            }else if (cmp < 0){
                curr = curr.right;
            }else {
                res = curr;
                curr = curr.left;
            }
        }


        return res ;
    }
    
    private TreeNode min(TreeNode root){
        TreeNode ans = root;
        for (TreeNode curr = root; curr != null; curr = curr.left){
            ans = curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(2);
        InorderSuccessor test = new InorderSuccessor();
        TreeNode ans = test.inorderSuccessor(root, new TreeNode(4));;
        System.out.println(ans == null? null : ans.val);
    }
}
