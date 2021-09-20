package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.Objects;

public class Q337 {
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return Math.max(
                    value(root)
                            + rob(left(left(root))) + rob(right(left(root)))
                            + rob(left(right(root))) + rob(right(right(root))),
                    rob(left(root)) + rob(right(root)));
        }

    }

    private TreeNode left(TreeNode node) {
        return Objects.nonNull(node) ? node.left : null;
    }

    private TreeNode right(TreeNode node) {
        return Objects.nonNull(node) ? node.right : null;
    }

    private int value(TreeNode node){
        return Objects.nonNull(node) ? node.val : 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        Q337 test = new Q337();
        System.out.println(test.rob(root));
    }
}
