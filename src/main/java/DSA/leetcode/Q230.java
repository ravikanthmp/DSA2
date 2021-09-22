package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q230 {

    class ResultWrapper{
        TreeNode result;
        int count;

        public int getCount() {
            return count;
        }

        public void setResult(TreeNode res){
           this.result = res;
       }

        public TreeNode getResult() {
            return result;
        }

       public void increment(){
           this.count++;
       }

        public boolean hasResult(){
           return result != null;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        ResultWrapper resultWrapper = new ResultWrapper();
        kthSmallestHelper(root, k, resultWrapper);
        return resultWrapper.getResult().val;
    }

    private void kthSmallestHelper(TreeNode root, int k, ResultWrapper holder) {
        if (root != null && !holder.hasResult()) {
            // left
            kthSmallestHelper(root.left, k, holder);

            // this one
            if (!holder.hasResult()){
                holder.increment();
                if (holder.getCount() == k){
                    holder.setResult(root);
                }
            }

            // right
            kthSmallestHelper(root.right, k, holder);
        }
    }


}
