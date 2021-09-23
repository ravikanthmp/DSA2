package DSA.leetcode;

import java.util.Arrays;

public class Q416 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0){
            return false;
        }else {
            int target = sum/2;
            Boolean[][] memo = new Boolean[nums.length][];
            for (int i = 0; i < memo.length; i++) {
                memo[i] = new Boolean[target + 1];
            }

            return test(target, nums, 0, memo);
        }
    }

    private boolean test(int target, int[] nums, int idx, Boolean[][] memo) {
        if (idx == nums.length){
            return target == 0;
        }else {

            if (memo[idx][target] == null){
                memo[idx][target] = test(target, nums, idx + 1, memo) ||
                        test(target - nums[idx], nums, idx + 1, memo);
            }

            return memo[idx][target];
        }
    }

    public static void main(String[] args) {
        Q416 test = new Q416();
        int[] nums = {1,5,11,5};
        System.out.println(test.canPartition(nums));
    }

}
