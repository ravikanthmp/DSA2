package DSA.leetcode.topInterview.medium;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class ZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        List<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }

        int level = 0;
        while (!queue.isEmpty()){

            int size = queue.size();

            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode removed = queue.remove(0);
                if (removed.left != null){
                    queue.add(removed.left);
                }
                if (removed.right != null){
                    queue.add(removed.right);
                }
                if (level % 2 == 0){
                    levelList.addLast(removed.val);
                }else {
                    levelList.addFirst(removed.val);
                }

            }
            level++;
            res.add(levelList);
        }

        return res;
    }

}
