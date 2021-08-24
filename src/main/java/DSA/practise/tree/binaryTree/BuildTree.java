package DSA.practise.tree.binaryTree;


public class BuildTree {
    enum FROM{
        INORDER_POSTORDER,
        INORDER_PREORDER
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, FROM mode) {
        if (mode.equals(FROM.INORDER_POSTORDER)){
            return buildTreeInorderPostorder(inorder, postorder, 0, inorder.length - 1,
                    0, postorder.length - 1);
        }else {
            return buildTreeInorderPreorder(inorder, postorder, 0, inorder.length - 1,
                    0, postorder.length - 1);
        }

    }

    private TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder,
                               int inorderLo, int inorderHi,
                               int postorderLo, int postorderHi) {
       
        if (postorderLo > postorderHi || inorderLo > inorderHi){
            return null;
        }

        int root = postorder[postorderHi];
        int inorderIdx = search(inorder, inorderLo, inorderHi, root);
        if (inorderIdx < 0){
            throw new RuntimeException("postorder root not found");
        }
        TreeNode rootNode = new TreeNode(root);

        int inorderSize = (inorderIdx - inorderLo);
        
        rootNode.left =
                buildTreeInorderPostorder(inorder, postorder, inorderLo, inorderIdx - 1, postorderLo, postorderLo + inorderSize - 1);

        rootNode.right =
                buildTreeInorderPostorder(inorder, postorder, inorderIdx + 1, inorderHi, postorderLo + inorderSize, postorderHi - 1);

        return rootNode;
    }

    private int search(int[] ints, int lo, int hi, int element) {
        for (int i = lo; i <= hi ; i++) {
            if (ints[i] == element){
                return i;
            }
        }
        return -1;
    }


    public TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder) {
        return buildTreeInorderPostorder(inorder, postorder, 0, inorder.length - 1,
                0, postorder.length - 1);
    }


    public TreeNode buildTreeInorderPreorder(int[] inorder, int[] preorder) {
        return buildTreeInorderPreorder(inorder, preorder, 0, inorder.length - 1,
                0, preorder.length - 1);
    }

    private TreeNode buildTreeInorderPreorder(int[] inorder, int[] preorder,
                                              int inLo, int inHi,
                                              int preLo, int preHi) {
        if (inLo > inHi || preLo > preHi){
            return null;
        }else {
            int rootEl = preorder[preLo];
            int rootIdxInInorder = search(inorder, inLo, inHi, rootEl);
            int leftSubTreeSize = rootIdxInInorder - inLo ;
            TreeNode node = new TreeNode(rootEl);
            node.left = buildTreeInorderPreorder(inorder, preorder,
                    inLo, rootIdxInInorder - 1,
                    preLo + 1, preLo + leftSubTreeSize);

            node.right = buildTreeInorderPreorder(inorder, preorder,
                    rootIdxInInorder + 1, inHi,
                    preLo + leftSubTreeSize + 1, preHi) ;

            return node;
        }
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTreeInorderPreorder(inorder, postorder);
    }
}
