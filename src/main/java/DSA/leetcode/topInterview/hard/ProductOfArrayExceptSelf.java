package DSA.leetcode.topInterview.hard;

public class ProductOfArrayExceptSelf {


    public int[] productExceptSelf(int[] nums) {

        int prefix = nums[0];
        int[] suffix = suffix(nums);
        int[] res = new int[nums.length];
        res[0] = suffix[1];

        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = prefix * suffix[i];
            prefix = prefix * nums[i];
        }
        return res;
    }


    private int[] suffix(int[] nums){
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];

        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = nums[i] * suffix[i + 1];
        }
        return suffix;
    }

}
