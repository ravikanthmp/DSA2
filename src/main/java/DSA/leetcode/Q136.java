package DSA.leetcode;

import java.util.stream.IntStream;

public class Q136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1};
        Q136 test = new Q136();
        System.out.println(test.singleNumber(arr));
    }

}
