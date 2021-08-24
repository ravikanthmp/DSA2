package DSA.practise.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static DSA.practise.tree.binaryTree.Traversal.TYPE.POSTORDER;
import static DSA.practise.tree.binaryTree.Traversal.TYPE.PREORDER;

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
        if (curr != null){
            stack.push(curr);
        }
        while (!stack.isEmpty()){
            curr = stack.pop();
            results.add(curr.val);
            if (curr.right != null){
               stack.push(curr.right);
            }
            if (curr.left != null){
                stack.push(curr.left);
            }
        }
        return results;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        TreeNode last = null;
        while (!stack.isEmpty()){
            curr = stack.peek();

            Integer val = curr.val;
            if (curr.right != null){
                if (last != null && last == curr.right){
                    last = stack.pop();
                    results.add(last.val);
                }else {
                    curr = curr.right;
                    while (curr != null){
                        stack.push(curr);
                        curr = curr.left;
                    }
                }

            }else {
                last = stack.pop();
                results.add(last.val);
            }
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
