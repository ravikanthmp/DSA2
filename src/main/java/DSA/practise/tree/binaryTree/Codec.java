package DSA.practise.tree.binaryTree;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String inorder = inorder(root);
        String postorder = postorder(root);
        return inorder.concat("$").concat(postorder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split("\\$");
        if (split.length != 2){
            return null;
        }
        String inorder = split[0];
        String postorder = split[1];

        int[] inorderArr = parse(inorder);
        int[] postorderArr = parse(postorder);


        return buildTreeInorderPostorder(inorderArr, postorderArr);
    }


    public TreeNode buildTreeInorderPostorder(int[] inorder, int[] postorder) {
        return buildTreeInorderPostorder(inorder, postorder, 0, inorder.length - 1,
                0, postorder.length - 1);
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

    private int[] parse(String order){
        String[] strings = order.split("#");
        int[] arr = new int[strings.length];
        int i = 0;
        for (String s : strings) {
            arr[i++] = Integer.parseInt(s);
        }
        return arr;
    }

    String inorder(TreeNode root){
        StringBuilder sb = new StringBuilder("");
        inorder(root, sb);
        return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).toString() : sb.toString();
    }

    void inorder(TreeNode root, StringBuilder sb){
        if (root == null){
            return;
        }else {
            inorder(root.left, sb);
            sb.append(root.val).append("#");
            inorder(root.right, sb);
        }
    }

    String postorder(TreeNode root){
        StringBuilder sb = new StringBuilder("");
        postorder(root, sb);
        return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).toString() : sb.toString();
    }

    private void postorder(TreeNode root, StringBuilder sb) {
        if (root == null){
            return;
        }else {
            postorder(root.left, sb);
            postorder(root.right, sb);
            sb.append(root.val).append("#");
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

    }
}
