package DSA.leetcode;

import DSA.practise.tree.binaryTree.TreeNode;

public class Q230 {

    class ResultHolder{
        int currK;
        boolean finished = false;
        int result;

        public boolean isDone(){
            return finished;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        ResultHolder resultHolder = new ResultHolder();
        visit(root, k, resultHolder);
        return resultHolder.result;
    }

    private void visit(TreeNode root, int k, ResultHolder resultHolder) {
        if (root != null){
            visit(root.left, k, resultHolder);
            if (!resultHolder.isDone()){
                resultHolder.currK++;
                if (resultHolder.currK == k){
                    resultHolder.finished = true;
                    resultHolder.result = root.val;
                }
                visit(root.right, k, resultHolder);
            }
        }
    }


}
