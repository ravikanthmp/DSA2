package DSA.practise.tree.bst;

public class LowestCommonAncestor {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int cmp = Integer.compare(p.val, q.val);
        TreeNode min = (cmp <= 0) ? p : q;
        TreeNode max =(min == p) ? q : p;

        TreeNode curr = root;
        while (curr != null){
            if (curr.val  < min.val){
                curr = curr.right;
            }else if (curr.val > max.val){
                curr = curr.left;
            }else {
                break;
            }
        }
        return curr;
    }

}
