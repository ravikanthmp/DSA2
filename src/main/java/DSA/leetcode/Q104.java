package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q104 {

    public int maxDepth(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.remove();
                if (first.left != null){
                    queue.add(first.left);
                }
                if (first.right != null){
                    queue.add(first.right);
                }
            }
            level++;
        }
        return level;
    }

}
