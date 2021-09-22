package DSA.practise;

public class SegmentTree {

    private int[] arr;
    private int[] tree;
    public SegmentTree(int[] arr) {
        this.arr = arr;
        buildTree();
    }

    private void buildTree() {
        int arrLength = nextPowerOfTwo(arr.length);
        int treeSize = 2 * arrLength;
        tree = new int[treeSize];
        int startIdx = arrLength;
        for (int i = 0; i < arr.length; i++) {
            tree[startIdx++] = arr[i];
        }
        for (int i = arrLength - 1; i > 0; i--){
            tree[i] = tree[2*i] + tree[2*(i+1)];
        }
    }

    private int nextPowerOfTwo(int n){
        double res = Math.log(n) / Math.log(2);
        int pow = (int)Math.ceil(res);
        return (int)Math.pow(2, pow);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
    }
}
