package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    /*
    T(N) = O(N)
    S(N) = O(D) diameter of the tree
     */
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
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
                if (i == size - 1){
                    res.add(first.val);
                }
            }
        }
        return res;
    }

}
