package DSA.leetcode;

public class Q152 {

    public int maxProduct(int[] nums) {

        int exclusive = Integer.MIN_VALUE;
        int inclusive = nums[0];
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            exclusive = Math.max(inclusive, exclusive);
            inclusive = inclusive * nums[i];
            maxSoFar = Math.max(maxSoFar, Math.max(nums[i],
                    Math.max(exclusive, inclusive)));
        }
        return Math.max(exclusive, inclusive);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        Q152 test = new Q152();
        System.out.println(test.maxProduct(arr));
    }
}
