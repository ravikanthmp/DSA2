package DSA.leetcode;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int l = 0;
        int sumSoFar = 0;
        int maxSoFar = 0;
        for (int r = 0; r < nums.length; r++) {
            if (sumSoFar < 0){
                l = r;
                sumSoFar = 0;
            }
            sumSoFar += nums[r];
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
