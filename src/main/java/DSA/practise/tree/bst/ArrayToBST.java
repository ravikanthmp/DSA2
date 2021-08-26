package DSA.practise.tree.bst;

public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi){
        if (lo > hi){
            return null;
        }else {
            int mid = lo + (hi - lo)/2;
            TreeNode node = new TreeNode(mid);

            node.left = sortedArrayToBST(nums, lo, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, hi);

            return node;
        }
    }

}
