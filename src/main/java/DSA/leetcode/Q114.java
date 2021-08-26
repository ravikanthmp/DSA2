package DSA.leetcode;

import DSA.practise.stack.Stack;
import DSA.practise.tree.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q114 {

    public void flatten(TreeNode root) {
        List<TreeNode> preorder = preorder(root);
        TreeNode prev = null;
        while (!preorder.isEmpty()){
            TreeNode node = preorder.remove(0);
            if (prev != null){
                prev.left = null;
                prev.right = node;
                prev = node;
            }else {
                prev = node;
            }
        }

    }

    private List<TreeNode> preorder(TreeNode node){
        List<TreeNode> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        if (node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }


        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            result.add(curr);

            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }

        }
        return result;
    }

}
