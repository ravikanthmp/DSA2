package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Q103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> results = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size= queue.size();
            Queue<Integer> levelItems ;
            if (level % 2 == 0){
                levelItems = new LinkedList();
            }else {
                levelItems = new ArrayDeque();
            }

            for (int i = 0; i < size; i++) {
                TreeNode removed = queue.remove();
                if (removed.left != null){
                    queue.add(removed.left);
                }
                if (removed.right != null){
                    queue.add(removed.right);
                }
                levelItems.add(removed.val);
            }

            List<Integer> list = new LinkedList<>();
            for (Integer item : levelItems){
                list.add(item);
            }
            results.add(list);
            level++;
        }
        return results;
    }

}
