package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q437 {

    class Count{
        int val;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Count count = new Count();
        Count prefixSumSoFar = new Count();
        Map<Integer, Integer> prefixSumSeenSoFar = new HashMap<>();
        dfs(root, new LinkedList<>(), count, targetSum, prefixSumSoFar, prefixSumSeenSoFar);
        return count.val;
    }

    private void dfs(TreeNode root, LinkedList<TreeNode> pathSoFar, Count count, int targetSum, Count prefixSumSoFar, Map<Integer, Integer> prefixSumSeenSoFar){
        if (root != null){
            pathSoFar.addFirst(root);
            prefixSumSoFar.val += root.val;

//            check(pathSoFar, count, targetSum);

            if (prefixSumSoFar.val == targetSum){
                count.val++;
            }
            int diff =  prefixSumSoFar.val - targetSum;
            count.val +=  prefixSumSeenSoFar.getOrDefault(diff, 0);

            prefixSumSeenSoFar.put(prefixSumSoFar.val, prefixSumSeenSoFar.getOrDefault(prefixSumSoFar.val, 0) + 1);

            dfs(root.left, pathSoFar, count, targetSum, prefixSumSoFar, prefixSumSeenSoFar);
            dfs(root.right, pathSoFar, count, targetSum, prefixSumSoFar, prefixSumSeenSoFar);

            pathSoFar.removeFirst();
            prefixSumSeenSoFar.put(prefixSumSoFar.val, prefixSumSeenSoFar.getOrDefault(prefixSumSoFar.val, 0) - 1);
            prefixSumSoFar.val -= root.val;

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        Q437 test = new Q437();
        System.out.println(test.pathSum(root, 8));
    }

}
