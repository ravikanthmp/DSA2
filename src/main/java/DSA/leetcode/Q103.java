package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

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

            LinkedList<TreeNode> nextLevelList = new LinkedList<>();

            List<Integer> resLevelList = new LinkedList<>();

            while (!queue.isEmpty()){
                if ((level % 2) != 0){
                    TreeNode remove = queue.removeFirst();
                    resLevelList.add(remove.val);
                    if (remove.left != null){
                        nextLevelList.addLast(remove.left);
                    }
                    if (remove.right != null){
                        nextLevelList.addLast(remove.right);
                    }

                }else {
                    TreeNode remove = queue.removeLast();
                    resLevelList.add(remove.val);
                    if (remove.right != null){
                        nextLevelList.addFirst(remove.right);
                    }
                    if (remove.left != null){
                        nextLevelList.addFirst(remove.left);
                    }

                }
            }

            level++;
            res.add(resLevelList);
            queue = nextLevelList;
        }

        return res;
    }
}
