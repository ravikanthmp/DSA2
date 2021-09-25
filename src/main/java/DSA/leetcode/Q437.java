package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.LinkedList;

public class Q437 {

    class Count{
        int val;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Count count = new Count();
        dfs(root, new LinkedList<>(), new Count(), targetSum);
        return count.val;
    }

    private void dfs(TreeNode root, LinkedList<TreeNode> pathSoFar, Count count, int targetSum){
        if (root != null){
            pathSoFar.addFirst(root);
            dfs(root.left, pathSoFar, count, targetSum);
            check(pathSoFar, count, targetSum);
            dfs(root.right, pathSoFar, count, targetSum);
            pathSoFar.removeFirst();
        }
    }

    private void check(LinkedList<TreeNode> pathSoFar, Count count, int target){
        int sum = 0;
        for (TreeNode node : pathSoFar){
            sum += node.val;
            if (sum == target){
                count.val++;
            }
        }
    }
}
