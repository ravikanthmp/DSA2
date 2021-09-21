package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Q337 {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            if (memo.containsKey(root)){
                return memo.get(root);
            }else {
                int ans =  Math.max(
                        value(root)
                                + rob(left(left(root))) + rob(right(left(root)))
                                + rob(left(right(root))) + rob(right(right(root))),
                        rob(left(root)) + rob(right(root)));
                memo.put(root, ans);
                return memo.get(root);
            }

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
}
