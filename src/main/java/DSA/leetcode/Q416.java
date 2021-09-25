package DSA.leetcode;

import java.util.Arrays;

public class Q416 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0){
            return false;
        }else {
            int target = sum/2;
            boolean[] memo = new boolean[sum + 1];
            boolean[] temp = new boolean[sum + 1];
            memo[nums[nums.length - 1]] = true;
            for (int i = nums.length - 2; i >= 0; i--) {

                for (int j = 0; j < memo.length; j++) {
                    if (memo[j]){
                        temp[j] = true;
                        temp[j + nums[i]] = true;
                    }
                }
                temp[nums[i]] = true;

                memo = temp;
                temp = new boolean[sum + 1];

                if (memo[target]){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Q416 test = new Q416();
        int[] nums = {1,5,11,5};
        System.out.println(test.canPartition(nums));
    }

}
