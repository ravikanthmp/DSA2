package DSA.practise.tree.bst;


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    int size = 1;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;

    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class KthLargest {

    TreeNode root;
    private int k;


    private void insert(int k){
        root = insert(root, k);
    }

    private TreeNode insert(TreeNode root, int k){
        if (root == null){
            return new TreeNode(k);
        }else {
            Integer cmp = Integer.compare(k, root.val);
            if (cmp <= 0){
                root.left = insert(root.left, k);
            }else {
                root.right = insert(root.right, k);
            }
            root.size = 1 + size(root.left) + size(root.right);
            return root;
        }
    }

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            insert(num);
        }
    }

    public int add(int val) {
        insert(val);
        return kthLargest(k);
    }

    private int kthLargest(int k){

        TreeNode curr = root;
        while (curr != null){
            int order = size(curr.right) + 1;
            if (order == k){
                break;
            }else if (k > order){
                k = k - (size(curr.right) + 1);
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }

        if (curr == null){
            return -1;
        }else {
            return curr.val;
        }

    }
    private int size(TreeNode node){
        return node == null ? 0 : node.size;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest test = new KthLargest(3, arr);
        System.out.println(test.add(3));
        System.out.println(test.add(5));
        System.out.println(test.add(10));
        System.out.println(test.add(9));
        System.out.println(test.add(4));

    }
}
