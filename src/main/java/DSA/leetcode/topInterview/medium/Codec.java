package DSA.leetcode.topInterview.medium;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.Stack;

public class Codec {

    private final String DELIMITER = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null){
            return "";
        }
        String preOrder = preOrder(root);
        String inOrder = inOrder(root);

        return preOrder + DELIMITER + inOrder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()){
            return null;
        }else {
            String[] split = data.split(DELIMITER);
            String preOrder = split[0];
            String inOrder = split[1];
            return construct(preOrder.split(","), inOrder.split(","));
        }
    }

    private String preOrder(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = null;

        if (root != null){
            stack.push(root);
        }

        while (!stack.isEmpty()){
            curr = stack.pop();
            sb.append(curr.val).append(",");

            if (curr.right != null){
                stack.push(curr.right);
            }

            if (curr.left != null){
                stack.push(curr.left);
            }
        }

        return sb.substring(0, sb.length() - 1);
    }

    private String inOrder(TreeNode root){
        StringBuilder sb = new StringBuilder();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()){
            curr = stack.pop();
            sb.append(curr.val).append(",");
            if (curr.right != null){
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }

        }

        return sb.substring(0, sb.length() - 1);
    }

    private TreeNode construct(String[] preOrder, String[] inOrder){
        return construct(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private TreeNode construct(String[] preOrder, String[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight){
            return null;
        }else {
            TreeNode root = new TreeNode(Integer.parseInt(preOrder[preLeft]));
            int rootVal = root.val;
            int inOrderIdx = -1;
            for (int i = inLeft; i <= inRight; i++) {
                if (Integer.parseInt(inOrder[i]) == rootVal){
                    inOrderIdx = i;
                    break;
                }
            }

            int L = (inOrderIdx - inLeft);
            int R = (inRight - inOrderIdx);

            root.left = construct(preOrder, inOrder, preLeft + 1, preLeft + L, inLeft, inLeft + L - 1);
            root.right = construct(preOrder, inOrder, preLeft + L + 1, preRight, inRight - R + 1, inRight);
            return root;
        }

    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode newRoot = codec.deserialize(serialize);
        System.out.println(codec.serialize(newRoot));
    }
}

