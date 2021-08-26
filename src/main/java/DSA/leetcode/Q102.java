package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> results = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode removed = queue.remove();
                if (removed.left != null){
                    queue.add(removed.left);
                }
                if (removed.right != null){
                    queue.add(removed.right);
                }
                level.add(removed.val);
            }
            results.add(level);
        }
        return results;
    }

}
