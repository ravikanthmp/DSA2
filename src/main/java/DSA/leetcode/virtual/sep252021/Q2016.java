package DSA.leetcode.virtual.sep252021;

public class Q2016 {
    public int maximumDifference(int[] nums) {
        int maxSoFar = nums[nums.length - 1];
        int maxDiffSoFar = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            maxDiffSoFar = Math.max(maxDiffSoFar, maxSoFar - nums[i]);
        }
        return maxDiffSoFar != 0 ? maxDiffSoFar : -1;
    }

    public static void main(String[] args) {
        Q2016 test = new Q2016();
        int[] nums = {7,1,5,4};
        System.out.println(test.maximumDifference(nums));
    }

}
