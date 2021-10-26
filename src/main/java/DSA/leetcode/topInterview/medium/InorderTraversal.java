package DSA.leetcode.topInterview.medium;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()){
            curr = stack.pop();
            res.add(curr.val);

            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }

        return res;
    }

}
