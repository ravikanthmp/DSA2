package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        // LrR
        TreeNode curr = root;
        while (curr != null){

            if (curr.left == null){
                inorder.add(curr.val);
                curr = curr.right;
            }else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr){
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null){
                    predecessor.right = curr;
                    curr = curr.left;
                }else {
                    inorder.add(curr.val);
                    predecessor.right = null;
                    curr = curr.right;
                }
            }

        }

        return inorder;
    };

    private TreeNode predecessor(TreeNode node){
        TreeNode curr = node.left;
        while (curr.right != node || curr.right != null){
            curr = curr.right;
        }
        return curr;
    }
}
