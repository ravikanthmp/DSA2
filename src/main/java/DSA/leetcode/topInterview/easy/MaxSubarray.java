package DSA.leetcode.topInterview.easy;

import java.util.Arrays;

public class MaxSubarray {

    public int maxSubArray(int[] nums) {
        return max(nums, 0, nums.length - 1);
    }

    private int max(int[] nums, int lo, int hi){
        if (lo > hi){
            return 0;
        } else if (lo == hi){
            return nums[lo];
        }else {
            int mid = lo + (hi - lo)/2;
            int left = max(nums, lo, mid - 1);
            int right = max(nums, mid + 1, hi);

            // across left
            int maxAcross = nums[mid];

            int currSum = 0;
            for (int i = mid - 1; i >= 0 ; i--) {
                if ((currSum + nums[i]) < 0){
                    break;
                }else {
                    currSum += nums[i];
                }
            }
            maxAcross += currSum;

            currSum = 0;
            for (int i = mid + 1; i < nums.length; i++) {
                if ((currSum + nums[i]) < 0){
                    break;
                }else {
                    currSum += nums[i];
                }
            }
            maxAcross += currSum;

            return Math.max(maxAcross, Math.max(left,right));
        }
    }


    public static void main(String[] args) {
        MaxSubarray maxSubarray = new MaxSubarray();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray.maxSubArray(arr));
    }

}
