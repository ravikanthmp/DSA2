package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;
import java.util.Stack;

public class Q226 {

    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()){
            curr = stack.pop();
            TreeNode currTemp = curr;
            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
            swapChildren(currTemp);
        }


        return root;
    }

    private void swapChildren(TreeNode root){
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

}
