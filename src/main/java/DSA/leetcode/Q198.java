package DSA.leetcode;

public class Q198 {

    /**
     * T(N) = O(N^2)
     * S(N) = O(N)
     */
    private Integer[] memo;
    private int[] nums;

    public int rob(int[] nums) {
        this.nums = nums;
        if (nums == null || nums.length == 0){
            return 0;
        }else if (nums.length == 1){
            return nums[0];
        }else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }else {
            memo = new Integer[nums.length];
            memo[nums.length - 1] = nums[nums.length - 1];
            memo[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
            return Math.max(f(0), f(1));
        }

    }

    private int f(int idx){
        if (idx >= nums.length){
            return 0;
        }else {
            Integer savedAns = memo[idx];
            if (savedAns == null){
                memo[idx] = Math.max(f(idx + 2) + nums[idx], f(idx + 1));
            }
            return memo[idx];
        }
    }

    public static void main(String[] args) {
        Q198 test = new Q198();
        int[] arr = {2, 1, 1, 2};
        System.out.println(test.rob(arr));
    }
}
