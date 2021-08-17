package DSA.leetcode;

public class Q55 {


    public boolean canJump(int[] nums) {
        int leftMostReachable = nums.length - 1;
        for (int i = nums.length - 2; i > 0; i--) {
            int farthest = Math.min(nums.length - 1, i + nums[i]);
            if (farthest >= leftMostReachable){
                leftMostReachable = i;
            }
        }
        int farthest = Math.min(nums.length - 1, nums[0]);
        return farthest >= leftMostReachable;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        Q55 test = new Q55();
        System.out.println(test.canJump(arr));
    }

}
