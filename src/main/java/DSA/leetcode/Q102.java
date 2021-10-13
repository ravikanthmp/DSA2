package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }

        while (!queue.isEmpty()){

            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.remove();
                levelList.add(first.val);
                if (first.left != null){
                    queue.add(first.left);
                }
                if (first.right != null){
                    queue.add(first.right);
                }
            }
            res.add(levelList);
        }
        return res;
    }
}
