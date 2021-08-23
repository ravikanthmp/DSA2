package DSA.practise.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


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

        }
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(inorder, postorder);
    }
}
