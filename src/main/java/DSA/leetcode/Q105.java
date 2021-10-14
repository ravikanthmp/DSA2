package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q105 {

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;
        this.inorder = inorder;

        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int preStart, int preEnd, int inStart, int inEnd){
        if ( (size(preStart, preEnd) != size(inStart, inEnd)) ||
                (preStart > preEnd)){
            return null;
        }else {
            TreeNode root = new TreeNode(preorder[preStart]);

            int rootIdxInorder = find(root.val, inStart, inEnd);
            if (rootIdxInorder < 0){
                // ?
                throw new RuntimeException("Cant be!");
            }else {
                int leftSubtreeSize = rootIdxInorder - inStart;
                int rightSubTreeSize = size(inStart, inEnd) - 1 - leftSubtreeSize;

                root.left = build(
                        preStart + 1, preStart + leftSubtreeSize,
                        inStart, inStart + leftSubtreeSize - 1);

                root.right = build(preEnd - rightSubTreeSize + 1, preEnd,
                        inEnd - rightSubTreeSize + 1, inEnd);

            }

            return root;
        }
    }

    private int find(int el, int start, int end){
        for (int i = start; i <= end ; i++) {
            if (inorder[i] == el){
                return i;
            }
        }
        return -1;
    }

    private int size(int lo, int hi){
        return hi - lo + 1;
    }

}
