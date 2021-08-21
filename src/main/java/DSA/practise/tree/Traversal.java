package DSA.practise.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static DSA.practise.tree.Traversal.TYPE.POSTORDER;
import static DSA.practise.tree.Traversal.TYPE.PREORDER;

public class Traversal {
    enum TYPE {
        INORDER,
        PREORDER,
        POSTORDER
    }

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

    public List<Integer> traversal(TreeNode root, TYPE type){
        if (type.equals(TYPE.INORDER)){
            return inOrderTraversal(root);
        }else if (type.equals(POSTORDER)){
            return postorderTraversal(root);
        }else if (type.equals(PREORDER)){
            return preorderTraversal(root);
        } else {
            return null;
        }
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null){
            results.add(curr.val);
            stack.push(curr);
            curr = curr.left;
        }
        while (!stack.isEmpty()){
            curr = stack.pop();
            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    results.add(curr.val);
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return results;
    }

    private List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()){
            curr = stack.pop();
            Integer val = curr.val;
            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
            results.add(val);
        }
        return results;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        while (!stack.isEmpty()){
            curr = stack.pop();
            results.add(curr.val);

            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }

        return results;
    }



}
