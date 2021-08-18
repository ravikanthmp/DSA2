package DSA.practise.progPatterns.slidingWindow;

public class MinSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int sumSoFar = 0;
        int minLength = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sumSoFar += nums[r];

            // valid window
            // try shrinking
            while (l <= r && sumSoFar >= target){
                minLength = Math.min(minLength, r - l + 1);
                l++;
            }
        }
        return minLength;
    }
}
