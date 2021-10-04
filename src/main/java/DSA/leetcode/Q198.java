package DSA.leetcode;

public class Q198 {

    /**
     * T(N) = O(N^2)
     * S(N) = O(N)
     */

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }else if (nums.length == 2){
            return Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        }else {
            int[] tab = new int[nums.length];
            tab[nums.length - 1] = nums[nums.length - 1];
            tab[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
            for (int i = nums.length - 3; i >= 0; i--) {
                tab[i] = Math.max(nums[i] + tab[i + 2], tab[i + 1]);
            }
            return tab[0];
        }

    }


    public static void main(String[] args) {
        Q198 test = new Q198();
        int[] arr = {1,2,3,1};
        System.out.println(test.rob(arr));
    }
}
