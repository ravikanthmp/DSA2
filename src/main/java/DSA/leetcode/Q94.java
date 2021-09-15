package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inorder = new ArrayList<>();
        // LrR
        TreeNode curr = root;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()){
            curr = stack.pop();

            // add to result
            inorder.add(curr.val);

            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }

        return inorder;
    };

}
