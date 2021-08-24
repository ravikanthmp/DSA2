package DSA.practise.tree.bst;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.Iterator;

public class BSTIterator implements Iterator<TreeNode> {
    private final TreeNode root;
    private TreeNode curr;

    public BSTIterator(TreeNode root) {
        this.root = root;
        for (TreeNode i = root; i != null; i = i.left){
            curr = i;
        }
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public TreeNode next() {
        TreeNode x = curr;
        curr = successor(x);
        return x;
    }

    TreeNode successor(TreeNode x){
        TreeNode curr = root;
        TreeNode par = null;
        while (curr != null){
            int cmp = Integer.compare(x.val, curr.val);
            if (cmp == 0){
                break;
            }else if (cmp < 0){
                par = curr;
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
        if (curr == null){
            return null;
        }else if (curr.right != null){
            return min(curr.right);
        }else {
            return par;
        }
    }

    TreeNode min(TreeNode root){
        TreeNode ans = root;
        for (TreeNode curr = root; curr != null; curr = curr.left){
            ans = curr;
        }
        return ans;
    }
}
