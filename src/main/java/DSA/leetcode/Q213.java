package DSA.leetcode;

public class Q213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {

            return Math.max(robInternal(nums, 0, nums.length - 2),
                    robInternal(nums, 1, nums.length - 1));
        }
    }

    private int robInternal(int[] nums, int lo, int hi) {
        int[] tab = new int[nums.length];
        tab[hi] = nums[hi];
        tab[hi - 1] = Math.max(nums[hi], nums[hi - 1]);
        for (int i = hi - 2; i >= lo; i--) {
            tab[i] = Math.max(nums[i] + tab[i + 2], tab[i + 1]);
        }
        return tab[lo];
    }


    public static void main(String[] args) {
        int[] arr = {1};
        Q213 test = new Q213();
        System.out.println(test.rob(arr));
    }
}
