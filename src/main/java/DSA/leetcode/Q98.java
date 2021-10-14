package DSA.leetcode;

import java.util.Stack;
import DSA.practise.tree.binaryTree.TreeNode;

public class Q98 {

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode prev = null;
        while (!stack.isEmpty()){
            curr = stack.pop();

            if (prev != null){
                if (curr.val <= prev.val){
                    return false;
                }
                prev = curr;
            }else {
                prev = curr;
            }

            if (curr.right != null){
                curr = curr.right;
                while(curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }

        return true;
    }

}
