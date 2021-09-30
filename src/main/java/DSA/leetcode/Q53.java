package DSA.leetcode;

import java.util.Arrays;

public class Q53 {
    public int maxSubArray(int[] nums) {

        int max = Arrays.stream(nums).max().getAsInt();
        int sumSoFar  = 0;
        int maxSoFar = max;
        for (int num : nums) {
            sumSoFar += num;

            // shrink window if needed
            if (sumSoFar < 0) {
                sumSoFar = 0;
            }

            maxSoFar = Math.max(maxSoFar, sumSoFar);
        }
        return maxSoFar;

    }


    public static void main(String[] args) {
        Q53 test = new Q53();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(arr));
    }
}
