package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;
import org.apache.tools.ant.taskdefs.modules.Link;

import java.util.*;
import java.util.stream.Collectors;

public class Q103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }

        int level = 0;

        while (!queue.isEmpty()){

            LinkedList<Integer> resLevelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                if (level % 2 != 0){
                    resLevelList.addFirst(remove.val);
                }else {
                    resLevelList.addLast(remove.val);
                }

                if (remove.left != null){
                    queue.add(remove.left);
                }
                if (remove.right != null){
                    queue.add(remove.right);
                }
            }
            res.add(resLevelList);
            level++;
        }

        return res;
    }
}
