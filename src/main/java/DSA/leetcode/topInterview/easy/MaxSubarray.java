package DSA.leetcode.topInterview.easy;

import java.util.Arrays;

public class MaxSubarray {

    public int maxSubArray(int[] nums) {


        int windowSum = 0;
        int maxSoFar = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            if (windowSum < 0){
                windowSum = 0;
            }
            maxSoFar = Math.max(maxSoFar, windowSum);
        }

        if (maxSoFar == 0 ){
            int elMax = Arrays.stream(nums).max().getAsInt();
            if (elMax != 0){
                return elMax;
            }else {
                return 0;
            }
        }else {
            return maxSoFar;
        }
    }


}
