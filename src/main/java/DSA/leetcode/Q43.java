package DSA.leetcode;

import java.util.Arrays;

public class Q43 {

    private int[] nums;
    private Integer[] memo;

    public int jump(int[] nums) {
        this.nums = nums;
        this.memo = new Integer[nums.length];
        memo[nums.length - 1] = 0;
        jump(0);
        return memo[0];
    }

    private int jump(int idx) {
        int target = nums.length - 1;
        if (idx >= target) {
            return 0;
        } else {
            if (memo[idx] == null) {
                int ans = Integer.MAX_VALUE;
                int jumps = nums[idx];

                for (int i = 1; i <= jumps; i++) {
                    int ans2 = jump(idx + i);
                    if (ans2 != Integer.MAX_VALUE) {
                        ans = Math.min(ans, 1 + ans2);
                    }
                }
                memo[idx] = ans;
            }
            return memo[idx];
        }
    }

    public static void main(String[] args) {
        int[] arr = {0};
        Q43 test = new Q43();
        System.out.println(test.jump(arr));
    }
}
